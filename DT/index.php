
<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<meta charset="UTF-8">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="style.css" />
	<!-- <link rel="stylesheet" type="text/css" href="css/test.css" /> -->
	<!-- <link rel="stylesheet" type="text/css" href="css/reset.css" /> -->
	<!-- <link rel="stylesheet" type="text/css" href="css/style_index.css" /> -->
	<!-- <link href="css/bootstrap-theme.css" rel="stylesheet"> -->
	<script src="js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery.min.js"></script>
	<title>Tuyển sinh</title>
</head>
<body>
	<div class="container">
		<!--Header -->
		<div id="header" class="row">
			<div class="col-md-9">
				<p>CHƯƠNG TRÌNH QUẢN LÝ TUYỂN SINH ĐẠI HỌC HỆ KHÔNG CHÍNH QUY</p>
			</div>
			<div class="choose-year col-md-3">
				<div class="form-group row">
					<select class="form-control">
						<option value="1">Đợt 1 Học kì I năm 16-17</option>
						<option value="2">Đợt 2 Học kì I năm 16-17</option>
						<option value="3">Đợt 3 Học kì I năm 16-17</option>
					</select>
				</div>
			</div>
		</div>
	</div>
		<!-- navBar -->
		<div id="menu">
			<div  class="container">
				<ul>
					<li><a href="login.php">Trang chủ</a></li>
					<li> <a href="#">Tổ chức thi </a>
					<ul>
						<li><a href="index.php?id=1">Thông tin kì thi</a></li>
						<li><a href="index.php?id=2">Thí sinh dự thi</a></li>
						<li><a href="index.php?id=3">Đánh số báo danh</a></li>
						<li><a href="index.php?id=4">Phân phòng thi</a></li>
						<li><a href="index.php?id=5">Danh sách phòng thi</a></li>
					</ul>
					</li>
					<li><a href="#">Tổ chức chấm thi</a>
					<ul>
						<li><a href="index.php?id=6">Xử lý bài thi</a></li>
						<li><a href="index.php?id=7">Dồn túi phách</a></li>
					</ul>
					</li>
					<li> <a href="#">Hướng dẫn - Hỗ trợ </a></li>
					<div class="log-out">
						<span style="color: #fff;">Xin chào, <b>admin</b>!</span>
						<button type="submit" class="btn btn-success">Đăng xuất</button>
					</div>
				</ul>
			</div>
		</div>
		<!-- content -->
		<div class="container">
			<?php
				// session_start();
				// $_SESSION['category'] = $_GET['id'];
				// if($_SESSION['category']==1)
				// 	include_once 'tochuckithi.php';
				// else if($_SESSION['category'] == 2)
				// 	include_once 'thisinhduthi.php';
				// else if($_SESSION['category'] == 3)
				// 	include_once 'danhsobaodanh.php';
				// else if($_SESSION['category'] == 4)
				// 	include_once 'phanphongthi.php';
				// else if($_SESSION['category'] == 5)
				// 	include_once 'danhsachphongthi.php';
				// else if($_SESSION['category'] == 6)
				// 	include_once 'xulybaithi.php';
				// else if($_SESSION['category'] == 7)
				// 	include_once 'dontui.php';
				$id=1;
				if(isset($_GET['id'])) $id=$_GET['id'];
				switch ($id) {
					case 1:
						include_once 'tochuckithi.php';
						break;
					case 2:
						include_once 'thisinhduthi.php';
						break;
					case 3:
						include_once 'danhsobaodanh.php';
						break;
					case 4:
						include_once 'phanphongthi.php';
						break;
					case 5:
						include_once 'danhsachphongthi.php';
						break;
					case 6:
						include_once 'xulybaithi.php';
						break;
					case 7:
						include_once 'dontui.php';
						break;
				}
			?>
		</div>
		<!-- footer -->
		<div id="footer">
			<p> &copy; Bản quyền Trường Đại Học Khoa Học Huế </p>
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