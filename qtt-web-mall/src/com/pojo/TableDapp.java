package com.pojo;

import java.util.Date;

public class TableDapp {
	
	private int rowid;
	private String dappname;//名称
	private String dappemail;//邮件
	private String dappresume;//概述
	private String dappexplain;//描述
	private String dappweb;//官方地址
	private String dapplogo;//图片url
	private String dappowner;//作者
	private String dappaddress;//合约地址
	private String dappweibo;//微博信息
	private String dapptelegram;//TELEGRAM信息
	private String ddappwechat;//微信信息
	private String dappchaininfo;//主链信息
	private String dappgit;//GITHUB信息
	private String dappstates;//状态
	private String dappclassinfo;//分类
	private Date DappCreateDate;//创建时间
	private Date DappUpdateDate;//修改时间
	private String cn;
	private String coun;
	public String getCn() {
		return cn;
	}
	public void setCn(String cn) {
		this.cn = cn;
	}
	public String getCoun() {
		return coun;
	}
	public void setCoun(String coun) {
		this.coun = coun;
	}
	public int getRowid() {
		return rowid;
	}
	public void setRowid(int rowid) {
		this.rowid = rowid;
	}
	public String getDappname() {
		return dappname;
	}
	public void setDappname(String dappname) {
		this.dappname = dappname;
	}
	public String getDappemail() {
		return dappemail;
	}
	public void setDappemail(String dappemail) {
		this.dappemail = dappemail;
	}
	public String getDappresume() {
		return dappresume;
	}
	public void setDappresume(String dappresume) {
		this.dappresume = dappresume;
	}
	public String getDappexplain() {
		return dappexplain;
	}
	public void setDappexplain(String dappexplain) {
		this.dappexplain = dappexplain;
	}
	public String getDappweb() {
		return dappweb;
	}
	public void setDappweb(String dappweb) {
		this.dappweb = dappweb;
	}
	public String getDapplogo() {
		return dapplogo;
	}
	public void setDapplogo(String dapplogo) {
		this.dapplogo = dapplogo;
	}
	public String getDappowner() {
		return dappowner;
	}
	public void setDappowner(String dappowner) {
		this.dappowner = dappowner;
	}
	public String getDappaddress() {
		return dappaddress;
	}
	public void setDappaddress(String dappaddress) {
		this.dappaddress = dappaddress;
	}
	public String getDappweibo() {
		return dappweibo;
	}
	public void setDappweibo(String dappweibo) {
		this.dappweibo = dappweibo;
	}
	public String getDapptelegram() {
		return dapptelegram;
	}
	public void setDapptelegram(String dapptelegram) {
		this.dapptelegram = dapptelegram;
	}
	public String getDdappwechat() {
		return ddappwechat;
	}
	public void setDdappwechat(String ddappwechat) {
		this.ddappwechat = ddappwechat;
	}
	public String getDappchaininfo() {
		return dappchaininfo;
	}
	public void setDappchaininfo(String dappchaininfo) {
		this.dappchaininfo = dappchaininfo;
	}
	public String getDappgit() {
		return dappgit;
	}
	public void setDappgit(String dappgit) {
		this.dappgit = dappgit;
	}
	public String getDappstates() {
		return dappstates;
	}
	public void setDappstates(String dappstates) {
		this.dappstates = dappstates;
	}
	public String getDappclassinfo() {
		return dappclassinfo;
	}
	public void setDappclassinfo(String dappclassinfo) {
		this.dappclassinfo = dappclassinfo;
	}
	public Date getDappCreateDate() {
		return DappCreateDate;
	}
	public void setDappCreateDate(Date dappCreateDate) {
		DappCreateDate = dappCreateDate;
	}
	public Date getDappUpdateDate() {
		return DappUpdateDate;
	}
	public void setDappUpdateDate(Date dappUpdateDate) {
		DappUpdateDate = dappUpdateDate;
	}
	@Override
	public String toString() {
		return "TableDapp [rowid=" + rowid + ", dappname=" + dappname + ", dappemail=" + dappemail + ", dappresume="
				+ dappresume + ", dappexplain=" + dappexplain + ", dappweb=" + dappweb + ", dapplogo=" + dapplogo
				+ ", dappowner=" + dappowner + ", dappaddress=" + dappaddress + ", dappweibo=" + dappweibo
				+ ", dapptelegram=" + dapptelegram + ", ddappwechat=" + ddappwechat + ", dappchaininfo=" + dappchaininfo
				+ ", dappgit=" + dappgit + ", dappstates=" + dappstates + ", dappclassinfo=" + dappclassinfo
				+ ", DappCreateDate=" + DappCreateDate + ", DappUpdateDate=" + DappUpdateDate + "]";
	}
	public TableDapp(int rowid, String dappname, String dappemail, String dappresume, String dappexplain,
			String dappweb, String dapplogo, String dappowner, String dappaddress, String dappweibo,
			String dapptelegram, String ddappwechat, String dappchaininfo, String dappgit, String dappstates,
			String dappclassinfo, Date dappCreateDate, Date dappUpdateDate) {
		super();
		this.rowid = rowid;
		this.dappname = dappname;
		this.dappemail = dappemail;
		this.dappresume = dappresume;
		this.dappexplain = dappexplain;
		this.dappweb = dappweb;
		this.dapplogo = dapplogo;
		this.dappowner = dappowner;
		this.dappaddress = dappaddress;
		this.dappweibo = dappweibo;
		this.dapptelegram = dapptelegram;
		this.ddappwechat = ddappwechat;
		this.dappchaininfo = dappchaininfo;
		this.dappgit = dappgit;
		this.dappstates = dappstates;
		this.dappclassinfo = dappclassinfo;
		DappCreateDate = dappCreateDate;
		DappUpdateDate = dappUpdateDate;
	}
	public TableDapp() {
		super();
	}
	
	
	
	
	
}
