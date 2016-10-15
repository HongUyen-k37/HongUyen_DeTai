<div class="row">
	<div class="thongtinkithi" style="width:95%;margin:25px auto;border:1px solid #ccc;">
		<div class="main-nav" style="margin:30px;">
			<?php
				include_once 'thongtin.php'; 
			?>  
			</form>
		</div>
	</div>
	<div class="content-kithi" style="width:95%;margin:25px auto;padding:30px;border:1px solid #ccc;">
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
			<div style="margin-top: 40px">
				<label>Lượt</label>
				<input class="form-control" type="number" name="luot" style="width: 30%; display: inline; margin-left: 10px">
				<label>/Số lượt thực hiện</label>
				<input class="form-control" type="text" name="soluot" style="width: 30%; display: inline; margin-left: 10px">
			</div>
		</form>
	</div>
	<div class="details-list">
		<div class="main-list">
			<table class="table table-bordered table-hover table-striped">
			<thead>
				<tr>
					<th></th>
					<th colspan="2">Phòng 1</th>
					<th colspan="2">Phòng 2</th>
					<th colspan="2">Phòng 3</th>
					<th colspan="2">Phòng 4</th>
					<th colspan="2">Phòng 5</th>
				</tr>
			</thead>
			<thead>
				<tr>
					<th></th>
					<th>SBD</th>
					<th>Số phách</th>
					<th>SBD</th>
					<th>Số phách</th>
					<th>SBD</th>
					<th>Số phách</th>
					<th>SBD</th>
					<th>Số phách</th>
					<th>SBD</th>
					<th>Số phách</th>
				</tr>
			</thead>
			<tbody>
			<thead>
				<tr>
					<th>Túi 1</th>
						<td>001</td>
						<td>167</td>
						<td>002</td>
						<td>168</td>
						<td>003</td>
						<td>169</td>
						<td>004</td>
						<td>170</td>
						<td>005</td>
						<td>171</td>
				</tr>

			</thead>
			<thead>
				<tr>
					<th>Túi 2</th>
						<td>001</td>
						<td>167</td>
						<td>002</td>
						<td>168</td>
						<td>003</td>
						<td>169</td>
						<td>004</td>
						<td>170</td>
						<td>005</td>
						<td>171</td>
				</tr>
			</thead>
			<thead>
				<tr>
					<th>Túi 3</th>
						<td>001</td>
						<td>167</td>
						<td>002</td>
						<td>168</td>
						<td>003</td>
						<td>169</td>
						<td>004</td>
						<td>170</td>
						<td>005</td>
						<td>171</td>
				</tr>
			</thead>
			<thead>
				<tr>
					<th>Túi 4</th>
						<td>001</td>
						<td>167</td>
						<td>002</td>
						<td>168</td>
						<td>003</td>
						<td>169</td>
						<td>004</td>
						<td>170</td>
						<td>005</td>
						<td>171</td>
				</tr>
			</thead>
			</tbody>
			</table>
			<div class="totalCandidates">
					<p>Danh sách gồm có : <span> 50/100 </span> sinh viên</p>
			</div>
		</div>
	</div>
	</div>
</div>