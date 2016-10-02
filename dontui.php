
<div class="col-md-9 main-content">
	<div class="numbered-list">
		<h3>DỒN TÚI</h3>
		<form style="width:60%;margin-left:110px;">
			<div class="form-group row">
				<label class="col-md-4" for="tdn">Cơ số phòng</label>
				<div class="col-md-8 ">
					<input type="number" class="form-control" name="cosophong" min="1">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-md-4" for="sbd">Cơ số túi</label>
				<div class="col-md-8 ">
					<input type="number" class="form-control" name="cosotui" min="1">
				</div>
			</div>
			<div class="btn-group">
				<button type="submit" class="btn btn-success" name='execute'>Thực hiện</button>
			</div>
			<div class="form-group row">
				<label class="col-md-4" for="sbd" style="margin-top: 15px;">Lượt </label>
				<p>Lượt dồn túi</p>
				<div class="col-md-8 ">
					<input type="number" class="form-control" name="sbd" min="1" style="margin-top: 15px; width: 30%;">
				</div>	
					<div class="col-md-8 ">
					<input type="text" class="form-control" name="tdn">
					</div>
				
			</div>
		</form>
	</div>
	<div class="details-list">
		<div class="main-list">
			<table class="table table-bordered table-hover table-striped">
			<thead>
				<tr>
					<th>Phòng 1</th>
					<th>Phòng 2</th>
					<th>Phòng 3</th>
					<th>Phòng 4</th>
					<th>Phòng 5</th>
				</tr>
			</thead>
			<thead>
				<tr>
					<th>SBD</th>
					<th>Phòng 2</th>
					<th>Phòng 3</th>
					<th>Phòng 4</th>
					<th>Phòng 5</th>
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
			<div class="totalCandidates">
					<p>Danh sách gồm có : <span> 50/100 </span> sinh viên</p>
			</div>
		</div>
	</div>
</div>
<?php
include_once 'contentNav.php';
?>
