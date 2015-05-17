<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>比特能专家系统 - 后台管理</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!-- bootstrap -->
<link rel="stylesheet"
	href="/robot/resources/css/bootstrap/bootstrap.css" />
<link rel="stylesheet"
	href="/robot/resources/css/bootstrap/bootstrap-responsive.css" />
<link rel="stylesheet"
	href="/robot/resources/css/bootstrap/bootstrap-overrides.css" />
<!-- libraries -->
<link
	href="/robot/resources/css//backend/lib/jquery-ui-1.10.2.custom.css"
	rel="stylesheet" type="text/css" />
<link href="/robot/resources/font/css/font-awesome.min.css"
	type="text/css" rel="stylesheet" />
<!-- global styles -->
<link rel="stylesheet" type="text/css"
	href="/robot/resources/css/backend/layout.css" />
<link rel="stylesheet" type="text/css"
	href="/robot/resources/css/backend/elements.css" />
<link rel="stylesheet" type="text/css"
	href="/robot/resources/css/backend/icons.css" />
<!-- this page specific styles -->
<link rel="stylesheet"
	href="/robot/resources/css/backend/expert-list.css"
	type="text/css" media="screen" />
</head>
<body>
	<!-- navbar -->
	<jsp:include page="../common/navbar.jsp"></jsp:include>
	<!-- sidebar -->
	<jsp:include page="../common/sidebar.jsp"></jsp:include>
	<!-- main container -->
	<div class="content">
		<c:if test="${not empty message}">
			<c:choose>
				<c:when test="${message.type eq 'info'}">
					<div class="alert alert-info">
						<i class="fa fa-exclamation-circle"></i>
						${message.content}
					</div>
				</c:when>
				<c:when test="${message.type eq 'error'}">
					<div class="alert alert-error">
						<i class="fa fa-exclamation-triangle "></i>
						${message.content}
					</div>
				</c:when>
			</c:choose>
		</c:if>
		<div class="container-fluid">
			<div id="pad-wrapper" class="users-list">
				<div class="row-fluid header">
					<h3>专家列表</h3>
					<div class="span10 pull-right">
						<input type="text" class="span5 search"
							placeholder="按条件搜索专家..." />

						<!-- custom popup filter -->
						<!-- styles are located in css/elements.css -->
						<!-- script that enables this dropdown is located in js/theme.js -->
						<div class="ui-dropdown">
							<div class="head" data-toggle="tooltip" title="Click me!">
								搜索 <i class="arrow-down"></i>
							</div>
							<div class="dialog">
								<div class="pointer">
									<div class="arrow"></div>
									<div class="arrow_border"></div>
								</div>
								<div class="body">
									<p class="title">选择查找条件:</p>
									<div class="form">
										<select>
											<option>姓名</option>
											<option>性别</option>
											<option>组织</option>
											<option>Signed up</option>
											<option>Last seen</option>
										</select> <select>
											<option>is equal to</option>
											<option>is not equal to</option>
											<option>is greater than</option>
											<option>starts with</option>
											<option>contains</option>
										</select> <input type="text" /> <a class="btn-flat small">Add
											filter</a>
									</div>
								</div>
							</div>
						</div>

						<a href="/robot/backend/expert/add" class="btn-flat success pull-right"> <span>&#43;</span>
							添加专家
						</a>
					</div>
				</div>

				<!-- Users table -->
				<div class="row-fluid table">
					<table class="table table-hover">
						<thead>
							<tr>
								<th class="span3 sortable">姓名</th>
								<th class="span2 sortable"><span class="line"></span>性别</th>
								<th class="span2 sortable"><span class="line"></span>论文数</th>
								<th class="span2 sortable"><span class="line"></span>专利数</th>
								<th class="span3 sortable align-right"><span class="line"></span>Email
								</th>
							</tr>
						</thead>
						<tbody>
							
							<c:forEach items="${experts}" var="expert">
							<!-- row -->
							 <tr class="first">
								<td>
								<img src="/robot/resources/img/backend/user-thumb.png" class="img-circle avatar hidden-phone" /> 
								<a href="/robot/backend/expert/${expert.expertId}" class="name">周志华</a> <span class="subtext">南京大学</span></td>
								<td>${expert.gender}</td>
								<td>${expert.paperNum}</td>
								<td>${expert.patentNum}</td>
								<td class="align-right">
								<c:when test="${empty expert.email}">
									<a href="/robot/backend/expert/${expert.expertId}">暂未记录Email</a>
								</c:when>
								<c:otherwise>
									<a href="/robot/backend/expert/${expert.expertId}">${expert.email}</a>
								</c:otherwise>
								</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="pagination pull-right">
				<c:choose>
					<c:when test="${empty param.page or param.page lt 5}">
							<ul>
								<c:choose>
									<c:when test="${param.page eq 1}">	
									<li class="disabled"><a href="#">&#8249;</a></li>
										<li ><a class="active" href="#">1</a></li>
									</c:when>
									<c:otherwise>
									
									<li><a href="/robot/backend/expert/experts?page=${param.page-1}">&#8249;</a></li>
									<li><a href="/robot/backend/expert/experts?page=1">1</a></li>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${param.page eq 2}">
										<li ><a class="active" href="#">2</a></li>
									</c:when>
									<c:otherwise>
										<li><a href="/robot/backend/expert/experts?page=2">2</a></li></c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${param.page eq 3}">
										<li><a class="active" href="#">3</a></li>
									</c:when>
									<c:otherwise>
										<li><a href="/robot/backend/expert/experts?page=3">3</a></li></c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${param.page eq 4}">
										<li><a class="active" href="#">4</a></li>
									</c:when>
									<c:otherwise>
										<li><a href="/robot/backend/expert/experts?page=4">4</a></li></c:otherwise>
								</c:choose>
								<li><a href="/robot/backend/expert/experts?page=5">5</a></li>
								<li><a href="/robot/backend/expert/experts?page=${param.page+1}">&#8250;</a></li>
							</ul>
						</c:when>
						<c:otherwise>
							<ul>
								<li><a href="/robot/backend/expert/experts?page=${param.page-1}">&#8249;</a></li>
								<li><a href="/robot/backend/expert/experts?page=${param.page-2}">${param.page-2}</a></li>
								<li><a href="/robot/backend/expert/experts?page=${param.page-1}">${param.page-1}</a></li>
								<li><a class="active" href="#">${param.page}</a></li>
								<li><a href="/robot/backend/expert/experts?page=${param.page+1}">${param.page+1}</a></li>
								<li><a href="/robot/backend/expert/experts?page=${param.page+2}">${param.page+2}</a></li>
								<li><a href="/robot/backend/expert/experts?page=${param.page+1}">&#8250;</a></li>
							</ul>									
						</c:otherwise>
				</c:choose>
				
				</div>
				<!-- end users table -->
			</div>
		</div>
	</div>
	<!-- end main container -->
	<!-- scripts -->
	<script src="/robot/resources/js/jquery/jquery-2.0.0.min.js"></script>
	<script src="/robot/resources/js/bootstrap/bootstrap.min.js"></script>
	<script src="/robot/resources/js/jquery/jquery-ui-1.10.2.custom.min.js"></script>
	<script src="/robot/resources/js/backend/common.js"></script>
	<!-- this page specific scripts -->
</body>
</html>