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
				<p class="title">XÁC ĐỊNH ĐIỂM CHUẨN</p>
				<div class="col-md-6 form-group row">
					<label class="col-md-4">Điểm liệt:</label>
					<div class="col-md-8">
						<input type="number" class="form-control" name="diemliet">
					</div>
				</div>
				<div class="col-sm-6">
					<form>
						<input type="radio" name="" checked>Bằng hoặc nhỏ hơn điểm liệt
						<input type="radio" name="">Nhỏ hơn điểm liệt
					</form>
				</div>
				<div>
					<label class="col-md-6">Điểm chuẩn cho khu vực 3 - không ưu tiên:</label>
					<div class="col-md-6">
						<input type="number" class="form-control" name="diemchuan">
					</div>
				</div>
				<div class="btn-gr">
					<button type="submit" class="btn btn-success btn-all" name="kt">Kiểm tra</button>
				</div>
			</div>
			<div class="details_info">
				<table class="table table-bordered table-hover table-striped">
							<thead>
								<tr>
									<th>KV - Đối tượng</th>
									<th>Điểm</th>
									<th>Số TS Đạt</th>
									<th>Số TS Không Đạt</th>
									<th>Số TS Bị Điểm Liệt</th>
									<th>Tổng</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>Khu vực 3 - KUT</td>
									<td>15.0</td>
									<td>20</td>
									<td>1</td>
									<td>0</td>
									<td>21</td>
								</tr>
								<tr>
									<td>Khu vực 3 - KUT</td>
									<td>15.0</td>
									<td>20</td>
									<td>1</td>
									<td>0</td>
									<td>21</td>
								</tr>
								<tr>
									<td>Khu vực 3 - KUT</td>
									<td>15.0</td>
									<td>20</td>
									<td>1</td>
									<td>0</td>
									<td>21</td>
								</tr>
							</tbody>
						</table>
				<div class="btn-gr">
					<button type="submit" class="btn btn-success btn-all" name="xddc">Xác định điểm chuẩn</button>
				</div>		
			</div>
		</div>
	</div>
</div>