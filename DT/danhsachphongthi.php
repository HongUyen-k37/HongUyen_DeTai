<div class="row">
	<div class="col-md-4 no-pad">
		<div class="thongtinkithi group-content">
			<div class="main-nav">
				<?php
					include_once 'thongtin-side.php'; 
				?>
			</div>
		</div>
	</div>
	<div class="col-md-8">
		<div class="group-content">
			<div class="row main-nav">
			<p class="title">PHÒNG THI</p>
			<form>
			<div class="form-group row">
				<label class="col-md-2" for="sl">Danh sách:</label>
				<div class="col-md-10">
					<select class="form-control">
						<option value="xtc">Xem tất cả</option>
						<option value="01">Phòng số 01</option>
						<option value="02">Phòng số 02</option>
						<option value="03">Phòng số 03</option>
					</select>
				</div>
			</div>
			</form>
			</div>
			<div class="phanphong">
				<div id="content-room">
					<div class="header-room row">
					<div class="menu-child col-md-9">
				<ul>
					<li><a href="index.php?n=1">Danh sách phòng thi</a></li>
					<li><a href="index.php?n=2">Biên bản phòng thi</a></li>
				</ul>
			</div>
			<div class="file-excel col-md-3 main-nav">
				<a href="#"> Xuất sang file excel</a>
			</div>
		</div>
			<?php	
				include_once 'tab1.php';
			?>
		</div>
		</div>
	</div>
	</div>
</div>