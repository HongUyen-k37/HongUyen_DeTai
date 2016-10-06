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
		<div class="numbered-list">
		<h3>XỬ LÝ BÀI THI</h3>
		<h4 style="margin-left: 100px;">Phòng thi</h4>
		<table class="table table-bordered table-hover table-striped">
			<thead>
				<tr>
					<th>Số hiệu phòng thi</th>
					<th>Số lượng</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>01</td>
					<td>25</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="details-list">
		<h3>Danh sách các thí sinh dự thi</h3>
		<div class="main-list">
			<table class="table table-bordered table-hover table-striped">
			<thead>
				<tr>
					<th>STT</th>
					<th>Số báo danh</th>
					<th>Họ đệm</th>
					<th>Tên</th>
					<th>Ngày sinh</th>
					<th>Xử lý thi</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>001</td>
					<td>Trần Thị Hồng</td>
					<td>Uyên</td>
					<td>02/11/1995</td>
					<td>
						<select class="form-control">
							<option value="vangthi">Dự thi</option>
							<option value="dinhchi">Đình chỉ thi</option>
							<option value="dinhchi">Khiển trách</option>
							<option value="dinhchi">Vắng thi</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>2</td>
					<td>002</td>
					<td>Trần Nữ Như</td>
					<td>Quỳnh</td>
					<td>02/11/1995</td>
					<td>
						<select class="form-control">
							<option value="vangthi">Dự thi</option>
							<option value="dinhchi">Đình chỉ thi</option>
							<option value="dinhchi">Khiển trách</option>
							<option value="dinhchi">Vắng thi</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>3</td>
					<td>003</td>
					<td>Phạm Như Ngọc</td>
					<td>Tuấn</td>
					<td>02/11/1995</td>
					<td>
						<select class="form-control">
							<option value="vangthi">Dự thi</option>
							<option value="dinhchi">Đình chỉ thi</option>
							<option value="dinhchi">Khiển trách</option>
							<option value="dinhchi">Vắng thi</option>
						</select>
					</td>
				</tr>
			</tbody>
			</table>
			<div class="totalCandidates">
					<p>Danh sách gồm có : <span> 50/100 </span> sinh viên</p>
			</div>
			<div class="btn-group">
				<button type="submit" class="btn btn-success" name='execute' style="margin-left: 100px;">In Danh sách</button>
			</div>
		</div>
	</div>
	</div>
</div>