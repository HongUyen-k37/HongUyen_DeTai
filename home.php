
<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="style.css" />
	<link rel="stylesheet" type="text/css" href="css/style_home.css" />
	<link rel="stylesheet" type="text/css" href="css/reset.css" />
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/bootstrap-theme.css" rel="stylesheet">
	<script src="js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery.min.js"></script>
	<title>Tuyển sinh</title>
</head>
<body>
	<div id="container">
		<!--Header -->
		<div id="header">
			<p>CHƯƠNG TRÌNH QUẢN LÝ TUYỂN SINH ĐẠI HỌC HỆ KHÔNG CHÍNH QUY</p>
		</div>
		<!-- navBar -->
		<div id="navBar">
			<div id="menu">
				<ul>
					<li><a href="index.php">Trang chủ</a></li>
					<li> <a href="home.php">Tổ chức thi </a>
					<ul>
						<li><a href="home.php?page=1">Thông tin kì thi</a></li>
						<li><a href="home.php?page=2">Thí sinh dự thi</a></li>
						<li><a href="home.php?page=3">Đánh số báo danh</a></li>
						<li><a href="home.php?page=4">Phân phòng thi</a></li>
					</ul>
					</li>
					<li><a href="#">Tổ chức chấm thi</a>
					<ul>
						<li><a href="#">Xử lý bài thi</a></li>
						<li><a href="#">Dồn túi phách</a></li>
					</ul>
					</li>
					<li> <a href="#">Hướng dẫn-Hỗ trợ </a></li>
				</ul>
			</div>
		</div>
		<div class="clear"></div>
		<!-- content -->
		<div id="content" class=" row ">
			<?php
				
				//include_once 'info.php';
				//include_once 'Candidates.php';
				//include_once 'mark.php'
				//include_once 'room.php'
				//include_once 'dontui.php'
				include_once 'xulybaithi.php'
			?>
		</div>
		<div class="clear"></div>
		<!-- footer -->
		<div id="footer">
			<p> &copy; Bản quyền Trường Đại Học Khoa Học Huế </p>
		</div>
	</div>
	<script type="text/javascript">
	$('#menu li').hover(
  		function() {
   		 $('ul', this).stop().slideDown(200);
 		 },
  		function() {
   		 $('ul', this).stop().slideUp(200);
 		 }
	);
	</script>
</body>
</html>