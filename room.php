<div class="col-md-9 main-content">
	<div class="room">
		<h3>Phòng thi</h3>
		<form style="width:60%;margin-left:110px;">
			<div class="form-group row">
			<label class="col-md-4" for="shpt">Số hiện phòng thi:</label>
			<div class="col-md-8 ">
				<input type="text" class="form-control" name="shpt">
			</div>
			</div>
			<div class="form-group row">
			<label class="col-md-4" for="slts">Số lượng thí sinh</label>
			<div class="col-md-8 ">
				<input type="number" class="form-control" name="slts" min="1">
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
		<div class="room-info">
			<table class="table table-bordered table-hover table-striped">
			<thead>
				<tr>
					<th>STT</th>
					<th>Số báo danh</th>
					<th>Họ đệm</th>
					<th>Tên</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>01</td>
					<td>Trần Nữ Như</td>
					<td>Quỳnh</td>
				</tr>
				<tr>
					<td>2</td>
					<td>02</td>
					<td>Trần Thị Hồng</td>
					<td>Uyên</td>
				</tr>
				<tr>
					<td>3</td>
					<td>03</td>
					<td>Phạm Như Ngọc</td>
					<td>Tuấn</td>
				</tr>
			</tbody>
			</table>
			<div class="row totalCandidates">
				<div class="col-md-10">
					<p>Danh sách gồm có : <span> 50/100 </span> sinh viên</p>
				</div>
				<div class="col-md-2 btn-group">
					<button type="submit" class="btn btn-success" name='payroll'>Biên chế</button>
				</div>
					
			</div>
		</div>
	</div>
</div>
<?php
include_once 'contentNav.php';
?>