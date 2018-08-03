'use static';

  // 创建一个 Dapp Item
  var renderDapp = null;
  // 绘制 表单页面 用户选择的 tags
  var renderTags = null;
  // 绘制Dapp状态
  var renderDappStatus = null;
  // 绘制基础链详情
  var renderChainInfo = null;
  // 提示模块
  var message = null;

  var queryString = function(str) {
    var res = {}
    str = str.replace(/\?/g,'').split('&&')
    for (var i = 0; i < str.length; i++) {
      var arr = str[i].split('=')
      if (arr[0]) {
        res[arr[0]] = decodeURI(arr[1])
      }
    }
    return res
  }

  var defaultStr = function (str) { return str === '' || str === null || str === undefined ? '--' : str }

$(function($){

  renderChainInfo = function(parent) {
    var del = $('<div class="form-group col-md-3"> <input id="addChain" class="btn btn-primary col-md-12" type="button" value="删除"></div>');
    del.on('click', function() {
      $(this).parent().remove()
    })
    var row = $('\
      <div class="form-row">\
        <div class="form-group col-md-3">\
          <select class="form-control" name="chain_name">\
            <option value="0">Mainnet</option>\
            <option value="1">Ropsten</option>\
            <option value="2">Kovan</option>\
            <option value="3">Rinkeby</option>\
          </select>\
        </div>\
        <div class="form-group col-md-6">\
          <input type="text" name="address" class="form-control" >\
        </div>\
      </div>\
    ').append(del)
    parent.append(row)
  }

  renderDappStatus = function (parent, statusSource, click) {
    parent.html('')
    for (var i = 0; i < statusSource.length; i++) {
      var data = statusSource[i]
      var eml = $('<li \
                  data-val="'+data.value+'" \
                  class="status '+data.className+' '+(data.active ? 'active' : '')+' "\
                  >'+data.text+'</li>\
                ')
      eml.on('click', click)
      parent.append(eml)
    }

  }
  renderTags = function (tags, parent, click){
    parent.html('')
    for (var i = 0; i < tags.length; i++) {
      var icon = $('<i data-str="'+tags[i]+'" class="dappfont icon-CLOSE"></i>')
      var eml = $('<span class="tagItem" >'+tags[i]+'</span>');
      eml.append(icon);
      icon.on('click', click);
      parent.append(eml);
    }
  }

  renderMessage = function (str, type) {
    console.log(str, type)
    var header = $('.header')
    if (header.find('.messages').length !== 0 || true) {
      var className = 'alert-success'
      switch (type) {
        case 'success':
          className = 'alert-success'
          break;
        case 'info':
          className = 'alert-info'
          break;
        case 'warning':
          className = 'alert-warning'
          break;
        case 'danger':
          className = 'alert-danger'
          break;
      }
      if (header.find('.messages').length !== -1) {
        header.append('\
          <ul class="messages">\
              <li class="alert '+ className +'">\
              '+str+'\
              </li>\
          </ul>\
        ')
      } else {
        header.append('\
          <li class="alert '+ className +'">\
          '+str+'\
          </li>\
        ')
      }
    }
  }

  renderDapp = function(data, style) {
    var isNew = data.isNew ? '<image class="new" src="/static/dapp/assets/new.svg" alt="new" />' : ''
    if (style === 'map') {
      return $('<div\
                data-id="'+data.id+'" \
                class="col-xs-12 col-sm-6 col-md-4 col-lg-3 item btn-showInfo statusModul '+data.class_name+'"\
              >\
              <a href="./detail/'+ data.id +'" target="_blank">\
                <div class="card box-shadow">\
                  <div class="card-body">\
                    <div class="name">\
                      '+ isNew +'\
                      <h4>'+data.name+'</h4>\
                      <p><span style="color: #999;">开发者: </span><span><strong>'+data.authors+'</strong></span></p>\
                    </div>\
                    <p class="card-text">'+data.teaser_desc+'</p>\
                    <div class=""></div>\
                    <div class="status-content">\
                      '+data.status+'\
                    </div>\
                  </div>\
                </div>\
              </a>\
            </div>');
    } else if (style === 'list') {
      var trs = $('.appItems .table tbody tr');
      return $('\
              <tr>\
                <td>'+ (trs.length + 1) +'</td>\
                  <td>\
                    '+ isNew +'\
                    <a href="./detail/'+ data.id +'" target="_blank">\
                      '+data.name+'\
                    </a>\
                  </td>\
                  <td>\
                    <div class="'+data.class_name+'-color btn status">\
                      '+data.status+'\
                    </div>\
                  </td>\
                  <td>'+defaultStr(data.dau)+'</td>\
                  <td>'+ defaultStr(data.tx_24h) + '</td>\
                  <td>'+ defaultStr(data.volume_24h) +'</td>\
                  <td>'+data.teaser_desc+'</td>\
                </tr>\
              ');
    }
  }
})
