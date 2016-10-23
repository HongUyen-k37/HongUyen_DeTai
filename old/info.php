

<div class="col-md-9 main-content">
	<h3>Thông tin kì thi</h3>
	<div class="main-table">
	<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>Tên kì thi</th>
			<th>Ngành</th>
			<th>Thời gian thi</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>TUYỂN SINH ĐẠI HỌC</td>
			<td>Công nghệ thông tin</td>
			<td>22/7/2016</td>
		</tr>
		<tr>
			<td>TUYỂN SINH ĐẠI HỌC</td>
			<td>Toàn học</td>
			<td>22/7/2016</td>
		</tr>
		<tr>
			<td>TUYỂN SINH ĐẠI HỌC</td>
			<td>Điện tử viễn thông</td>
			<td>22/7/2016</td>
		</tr>
		</tbody>
		</table>
	</div>
</div>
<div class="col-md-3 contentNav">
	<div class="nameuser">
	</div>
	<h3>Thông tin kì thi</h3>
	<div class="main-nav">
	<form method="post" action="home.php">
		<div class="form-group">
		<label for="study">Ngành:</label>
		<select class="form-control">
			<option value="it">Công nghệ thông tin</option>
			<option value="math">Toán học</option>
			<option value="art">Kiến trúc</option>
		</select>
		</div>
		<div class="form-group">
			<label for="year">Năm tuyển sinh:</label>
			<input type="number" class="form-control" name="number" min="2015">
		</div>
		<div class="form-group">
			<label for="forms-of-trainingr">Hình thức đào tạo:</label>
			<select class="form-control">
				<option value="university">Đại học</option>
				<option value="master">Cao học</option>
			</select>
		</div>
		<div class="form-group">
			<label for="trainingr">Cơ sở liên kết đào tạo:</label>
			<select class="form-control">
				<option value="FPT">FPT</option>
				<option value="gosu">Gosu</option>
			</select>
		</div>
		<div class="form-group">
			<label for="date">Ngày thi:</label>
			<input type="text" class="form-control" name="date" >
		</div>
		<div class="form-group">
			<label for="object">Danh sách môn thi:</label>
			<select class="form-control">
				<option value="1">Toán</option>
				<option value="2">Lý</option>
				<option value="3">Hóa</option>
			</select>
		</div>
		<div class="btn-group">
			<button type="submit" class="btn btn-success" name='add'>Thêm</button>
				<button type="submit" class="btn btn-success" name='update'>Lưu</button>
			<button type="submit" class="btn btn-success" name='delete'>Xóa</button>
		
		</div>
	</form>
	</div>
</div>
