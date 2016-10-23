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
	<div class="content-kithi group-content">
		<div class="row main-nav" >
		<p class="title">ĐÁNH SỐ BÁO DANH</p>
		<form>
			<div class="form-group row">
			<label class="col-md-4" for="tdn">Tiếp đầu ngữ:</label>
			<div class="col-md-8 ">
				<input type="text" class="form-control" name="tdn">
			</div>
			</div>
			<div class="form-group row">
			<label class="col-md-4" for="sbd">Số bắt đầu:</label>
			<div class="col-md-8 ">
				<input type="number" class="form-control" name="sbd" min="1">
			</div>
			</div>
			<div class="form-group row">
			<label class="col-md-4" for="sl">Số lượng:</label>
			<div class="col-md-8 ">
				<input type="number" class="form-control" name="sl" min="1">
			</div>
			</div>
			<div class="btn-center">
				<button type="submit" class="btn btn-success btn-all" name='execute'>Thực hiện</button>
			</div>
		</form>
	</div>
	<div class="details_info">
		<p class="title">DANH SÁCH CÁC THÍ SINH DỰ THI</p>
		<div class="main-list">
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
			<div class="totalCandidates">
					<p>Danh sách gồm có: <span> 50/100 </span> sinh viên</p>
			</div>
		</div>
	</div> <!-- end details -->
</div>