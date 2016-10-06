<div class="row">
	<div class="thongtinkithi" style="height:400px;width:95%;margin:25px auto;border:1px solid #ccc;">
		<div class="main-nav" style="height:100%;margin:30px;">
			<?php
				include_once 'thongtin.php'; 
			?>  
			</form>
		</div>
	</div>
	<div class="content-kithi" style="height:100%;width:95%;margin:25px auto;padding:30px;border:1px solid #ccc;">
		<div class="room">
		<h3>Phòng thi</h3>
		<form style="width:60%;">
			<div class="form-group row">
			<label class="col-md-4" for="sl">Danh sách:</label>
			<div class="col-md-8 ">
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
			<div class="file-excel col-md-3">
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