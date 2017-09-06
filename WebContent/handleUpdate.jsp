<%@page import="org.lanqiao.entity.User"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.lanqiao.service.impl.UserServiceImpl"%>
<%@page import="org.lanqiao.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	UserService us = new UserServiceImpl();
	String uuid = request.getParameter("uuid");
	String uname = request.getParameter("uname");
	String ujob = request.getParameter("ujob");
	String unick = request.getParameter("unick");
	String uemail = request.getParameter("uemail");
	String udate = request.getParameter("udate");
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	java.util.Date utilDate = format.parse(udate);
	java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	String umessage = request.getParameter("umessage");
	us.update(new User(uuid,uname,ujob,unick,uemail,sqlDate,umessage));
	response.sendRedirect("txl.jsp");
%>


