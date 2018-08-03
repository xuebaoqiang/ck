'use strict';

function toThousands(num) {
    var result = [ ], counter = 0;
    var lastNumber = ''
    num = (num || 0).toString()
    if (num.indexOf('.') !== -1) {
      lastNumber = num.substring(num.indexOf('.'), num.length)
      num = num.substring(0, num.indexOf('.'))
    }
    num = num.split('');
    for (var i = num.length - 1; i >= 0; i--) {
        counter++;
        result.unshift(num[i]);
        if (!(counter % 3) && i !== 0) {
          result.unshift(',');
        }
    }
    return result.join('') + lastNumber;
}

var option = {
    xAxis: {
        type: 'category',
        data: []
    },
    grid: {
      left: '80',
      right: '90',
      top: '30',
      bottom: '30',
      width: 'auto',
      height: 'auto'
    },
    tooltip: {
         trigger: 'axis',
         formatter: function(data) {
           var html = ''
           for (var i = 0; i < data.length; i++) {
             var color = data[i].color
             var seriesName = data[i].seriesName
             var value = data[i].value
             if (seriesName === 'Gas used') {
               value = value * 1000
             }
             value = toThousands(value)
             html += '<span style="width: 10px; margin-right: 5px; border-radius: 10px; display:inline-block; height: 10px; background-color: '+color+'"></span>'+seriesName+': '+value+'<br />'
           }
           return '<div>'+ html +'</div>'
       }
     },
    toolbox: {
        left: 'center',
    },
    yAxis: [
        {
            type: 'value',
            name: '交易笔数'
        },
        {
            type: 'value',
            name: "燃料费",
            nameLocation: 'end',
            splitLine: {
              show: false
            },
            axisLabel: {
              formatter: function (text) { return text + 'K' }
            }
        }
    ],
    series: []
};

$(function($) {
  var appItemsEml = $('.appItems');
  var btns = appItemsEml.find('.btn-showInfo');
  var appItems = $('.appItems .item');
  var appsContent = $('.appItems .container .map');
  var moreContent = $('#more');
  var loadMore = moreContent.find('.submit-myApp');
  var queryForm = $('#queryForm');
  var switchBtn = $('.switchStyle');
  var detailChart = $('#detailChart');
  var appInfo = $('.appInfo')

  var sortByTitle = $('.apps .table').find('th');

  // 详情页面中的 tab 切换
  appInfo.find('.nav-tabs .nav-item').on('click', function () {
    var link = $(this).find('a');
    appInfo.find('.nav-tabs .nav-item a').removeClass('active');
    if (link.attr('class').indexOf('active') === -1) {
      link.addClass('active')
      var key = link[0].dataset.key
      if (key === 'chart') {
        appInfo.find('.dataChart').css('display', 'block')
        appInfo.find('.contracts').css('display', 'none')
      } else if (key === 'table') {
        appInfo.find('.dataChart').css('display', 'none')
        appInfo.find('.contracts').css('display', 'block')
      }
    }
  })

  queryForm.on('submit', function(e) {
    if (queryForm.find('.form-control').val()) {
        return true
    } else {
      queryForm.find('.form-control').focus()
    }
    return false;
  })

  switchBtn.find('i').on('click', function() {
    if (appItemsEml.attr('class').indexOf('appItemsList') == -1) {
      appItemsEml.addClass('appItemsList');
      appItemsEml.find('i').attr('class', 'dappfont icon-list');
    } else {
      appItemsEml.removeClass('appItemsList');
      appItemsEml.find('i').attr('class', 'dappfont icon-grid');
    }
  })

  var numberToFixed = function (arr, format) {
    arr = $.map(arr, function (num) {
      if (num) {
        if (format) {
          return format(num).toFixed(2)
        } else {
          return num
        }
      } else {
        return num
      }
    })
    return arr
  }

  var getAppDetailChart = function (time) {
    var id = appInfo[0].dataset.id
    time = time || '7d'
    var url = '/chart?dappId='+ id +'&time=' + time;
    detailChart.find('#modal').remove()
    detailChart.append('<div id="modal" class="loading" ><div>loading...</div></div>')
    $.ajax({
      url: url,
      method: 'get',
      success: function(data) {
        if (data.status === 1) {
          var chart = echarts.init(detailChart.get(0))
          var x = data.result.x
          var transactions = numberToFixed(data.result.transactions)
          var gasUsed = numberToFixed(data.result.gasUsed, function(num){
             return num / 1000
          })
          // console.log(gasUsed, data.result.gasUsed)
          var volume = numberToFixed(data.result.volume)

          option.xAxis.data = x
          option.series = [
            { data: transactions, type: 'line', name: '交易笔数', yAxisIndex: 0, smooth: true },
            { data: gasUsed, type: 'line', name: '燃料费', yAxisIndex: 1, smooth: true,},
            { data: volume, type: 'line', name: '交易金额', yAxisIndex: 0, smooth: true }
          ]
          chart.setOption(option)
          $(window).on('resize', function() { chart.resize() })
          detailChart.find('#modal').remove()
        } else {
          var err = '图表加载失败: ' + data.status
          detailChart.append('<div id="modal" class="loading" ><div>'+ err +'</div></div>')
        }
        appInfo.find('.dataChart button').attr('disabled', false)
      },
      error: function() {
        detailChart.append('<div id="modal" class="error" ><div>图表加载失败</div></div>')
        appInfo.find('.dataChart button').attr('disabled', false)
      },
      fail: function() {
        detailChart.append('<div id="modal" class="error" ><div>图表加载失败</div></div>')
        appInfo.find('.dataChart button').attr('disabled', false)
      }
    })
  }

  // 页面第一次进来加载数据
  if (detailChart.length === 1) {
    /*
      loading
      success
      error
    */
    getAppDetailChart()
  }

  // 点击不同的时间加载数据
  appInfo.find('.dataChart button').on('click', function () {
    appInfo.find('.dataChart button').removeClass('active');
    appInfo.find('.dataChart button').attr('disabled', true)
    if (this.className.indexOf('active') === -1) {
      $(this).addClass('active')
      getAppDetailChart(this.dataset.val)
    }
  })

  // 加载更多
  // type = filter | tag
  // content
  loadMore.on('click', function() {
    var url = '/showMore?offset='+$('.appItems .table tbody tr').length
    var location = window.location
    var search = queryString(location.search)
    if (location.href.indexOf('/search') !== -1) {
      url += '&&content='+encodeURIComponent(search.content)
      url += '&&type=filter'
    } else if (location.href.indexOf('/tag') !== -1) {
      url += '&&content='+encodeURIComponent(search.tag)
      url += '&&type=tag'
    }
    var sortField = $("#hdnSortField").val();
    if (sortField !== ""){
      url += '&&sort_field=' + sortField;
    }

    $.get(url, function(res) {
        if (!res.show_more) {
          moreContent.html('<p class="btn" style="cursor: default !important;" >没有更多了</p>')
        }
        if (res.status === 1) {
          for (var i = 0; i < res.result.length; i++) {
            var dapp = res.result[i]
            appsContent.append(renderDapp(dapp, 'map'))
            $('.appItems .table tbody').append(renderDapp(dapp, 'list'))
          }
        } else {
          if (res.message) {
            renderMessage(res.message, 'danger')
          }
        }
      })
  });

  sortByTitle.on('click', function() {
    var sortField = $("#hdnSortField").val();
    if (sortField !== "" && this.dataset.field.indexOf(sortField) !== -1) {
      if (sortField.indexOf('-') === -1) {
        sortField = "-" + sortField;
      } else {
        sortField = sortField.slice(1);
      }
    } else {
      sortField = this.dataset.field;
    }
    var url = '/sortByTitle?offset=' + $('.appItems .table tbody tr').length + "&&sort_field=" + sortField
    var location = window.location
    var search = queryString(location.search)
    if (location.href.indexOf('/search') !== -1) {
      url += '&&content=' + encodeURIComponent(search.content)
      url += '&&type=filter'
    } else if (location.href.indexOf('/tag') !== -1) {
      url += '&&content=' + encodeURIComponent(search.tag)
      url += '&&type=tag'
    }

    $.get(url, function (res) {
      if (res.status === 1) {
        appsContent.html('');
        $('.appItems .table tbody').html('');
        $("#hdnSortField").val(res.sort_field);
        resetSort(res);
        for (var i = 0; i < res.result.length; i++) {
          var dapp = res.result[i]
          appsContent.append(renderDapp(dapp, 'map'));
          $('.appItems .table tbody').append(renderDapp(dapp, 'list'));
        }
      } else {
        if (res.message) {
          renderMessage(res.message, 'danger')
        }
      }
    })
  });

  function resetSort(res){
    $("#balanceUp").hide();
    $("#balanceDown").hide();
    $("#dauUp").hide();
    $("#dauDown").hide();
    $("#txUp").hide();
    $("#txDown").hide();
    $("#volumeUp").hide();
    $("#volumeDown").hide();
    if (res.sort_field === "static__balance") {
      $("#balanceUp").show();
    } else if (res.sort_field === "-static__balance") {
      $("#balanceDown").show();
    } else if (res.sort_field === "static__dau") {
      $("#dauUp").show();
    } else if (res.sort_field === "-static__dau") {
      $("#dauDown").show();
    } else if (res.sort_field === "static__tx_24h") {
      $("#txUp").show();
    } else if (res.sort_field === "-static__tx_24h") {
      $("#txDown").show();
    } else if (res.sort_field === "static__volume_24h") {
      $("#volumeUp").show();
    } else if (res.sort_field === "-static__volume_24h") {
      $("#volumeDown").show();
    }
  }

  // 表单页面
  ;(function() {
    var submitDapp = $('#submit-dapp')
    if (!submitDapp.length) return
    // 处理dapp的状态
    var input_status = submitDapp.find('#status');
    var input_tags = submitDapp.find('#id_tags');
    var user_Input_Tags = submitDapp.find('#tags_input');
    var tags = submitDapp.find('.tagsContent .tagItem');
    var tagResult = submitDapp.find('.tagResult');
    var tagsAdd = submitDapp.find('.tagsContent .icon-add');
    var addChain = submitDapp.find('#addChain');
    var userChooseTags = input_tags.val() ? input_tags.val().split(',') : []
    var statusSource = [
      { className: 'live-color', text: '已上线', value: 0, active: true },
      { className: 'beta-color', text: 'Beta测试', value: 1 },
      { className: 'prototype-color', text: '原型验证', value: 2 },
      { className: 'working-color', text: '开发中', value: 3 },
      { className: 'concept-color', text: '概念', value: 4 },
      { className: 'abandoned-color', text: '废弃', value: 5 },
    ]

    $('#btnSave').attr('disabled', false)
    // 初始化状态
    renderDappStatus(submitDapp.find('.form-status'), statusSource, function() {
      submitDapp.find('.form-status .status').each(function(i, eml) {
        $(eml).removeClass('active')
      })
      input_status.val(this.dataset.val);
      this.className += ' active';
    })
    // 增加基础链
    renderChainInfo(submitDapp.find('.block_chain_info'))
    addChain.on('click', function() {
      renderChainInfo(submitDapp.find('.block_chain_info'))
    })
    // 删除已选择的
    var userDelTags = function(e) {
      userChooseTags.splice(userChooseTags.indexOf(this.dataset.str), 1)
      renderTags(userChooseTags, tagResult, userDelTags);
      input_tags.val(userChooseTags.join(','))
    }

    // 初始化标签
    renderTags(userChooseTags, tagResult, userDelTags)
    tags.on('click', function() {
      if (userChooseTags.indexOf(this.innerHTML) === -1){
        userChooseTags.push(this.innerHTML)
        renderTags(userChooseTags, tagResult, userDelTags)
        input_tags.val(userChooseTags.join(','))
      }
    })

    // 添加 用户输入的 tag
    tagsAdd.on('click', function() {
      if (user_Input_Tags.val()) {
        userChooseTags.push(user_Input_Tags.val());
        renderTags(userChooseTags, tagResult, userDelTags);
        input_tags.val(userChooseTags.join(','));
        user_Input_Tags.val('');
      }
    })

  })();
})
