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
				<label class="col-md-4" for="first-name">Số hiệu phòng thi:</label>
				<div class="col-md-8 ">
					<input type="text" class="form-control" name="shpt">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-md-4" for="first-name">Số lượng thí sinh:</label>
				<div class="col-md-8 ">
					<input type="text" class="form-control" name="slts">
				</div>
			</div>
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
		<div class="list-room">
			<table class="table table-bordered table-hover table-striped">
			<thead>
				<tr>
					<th>STT</th>
					<th>Số báo danh</th>
					<th>Họ tên</th>
					<th>Ngày sinh</th>
					<th>Số hiệu phòng thi</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>01</td>
					<td>Trần Nữ Như Quỳnh</td>
					<td>26/05/1995</td>
					<td>01</td>
				</tr>
				<tr>
					<td>2</td>
					<td>02</td>
					<td>Trần Thị Hồng Uyên</td>
					<td>26/05/1995</td>
					<td>01</td>
				</tr>
				<tr>
					<td>3</td>
					<td>03</td>
					<td>Phạm Như Ngọc Tuấn</td>
					<td>26/05/1995</td>
					<td>01</td>
				</tr>
			</tbody>
			</table>
			<div class="row">
				<div class="col-sm-10">
					<p>Danh sách gồm có : <span> 50/100 </span> sinh viên</p>
				</div>
				<div class="btn-group col-sm-2">
					<button type="submit" class="btn btn-success" name='bienche'>Biên chế</button>
				</div>
			</div>
		</div>
		
	</div>
</div>
