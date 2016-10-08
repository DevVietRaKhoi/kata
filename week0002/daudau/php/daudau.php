<?php
/*
	explaination of my code. i got it from myself.
	Do đề bài là theo hình xoắn ốc, ta nhận thấy nó đưọc chia thành các lớp, mỗi lớp là 1 "vòng tròn". đường thẳng cũng là vòng tròn :D
	-> ý tưởng là dựa vào tọa độ của điểm trong array, ta cần xác định nó thuộc lớp thứ mấy của hình xoắn ốc và xác định giá trị tại điểm đó.
	Example data:
	N = 3; M = 4;
	-------------
	1	2	3	4

	10	11	12	5

	9	8	7	6
	-------------
*/

//nhập giá trị từ user.
fwrite(STDOUT, 'Input N: ');
fscanf(STDIN, "%d", $n);

fwrite(STDOUT, 'Input M: ');
fscanf(STDIN, "%d", $m);

$min = $m > $n ? $n : $m;  //tìm min của hàng và cột
$circle = ceil($min/2.0);  //xác định số vòng mà xoắn ốc sẽ có, dựa vào giá trị min.
$length = strlen($n*$m) + 1;  //sử dụng để in giá trị
$roundFirstValue = array();  //mảng này để lưu giá trị bắt đầu của mỗi vòng. VD vòng thứ 0 là 1, vòng thứ 1 là 11.

$roundFirstValue[0] = 1; //giá trị vòng đầu tiên luôn là 1.
for ($i =1; $i<$circle; $i++) {
	/**
	* giá trị bắt đầu mỗi vòng = giá trị bắt đầu của vòng trước đó + số số của vòng đó.
	* vd Vòng 1 là 1, và có số trong vòng đó => giá trị bắt đầu của vòng 2 là 1 + 10.
	* số lưọng phần tử trong 1 vòng bằng : ($n-($i-1)*2 + $m-($i-1)*2)*2 - 4
	*/
	$roundFirstValue[$i] = $roundFirstValue[$i-1] + ($n-($i-1)*2 + $m-($i-1)*2)*2 - 4;
}

$spiralArray = array();

for ($i=0; $i<$n; $i++)
	for ($j=0; $j<$m; $j++) {
		$tmpi = $i > ($n-1)/2 ? $n - 1 - $i : $i;
		$tmpj = $j > ($m-1)/2 ? $m - 1 - $j : $j;
		$round = $tmpi > $tmpj ? $tmpj : $tmpi;  //xác định 1 điểm thuộc vòng thứ mấy 
		//ta "đâm" vào vòng của nó 
		//they đổi tọa độ thành $ix, $jx, $nx, $mx.
		$ix = $i - $round;
		$jx = $j - $round;
		$nx = $n - $round*2;
		$mx = $m - $round*2;  
		/**
		* Ta tính giá trị 1 điểm thuộc 1 vòng bằng cách xác định xem nó nằm trên hay nằm dưói đưòng chéo của nó.
		* Nếu nằm "trên" (nghĩa là cả 2 điểm chéo) thỉ giá trị của nó bằng giá trị start của vòng + tọa độ cuản ó
		* Nếu nằm dưới thì sẽ bằng giá trị bắt đầu + số phần tử của vòng trừ đi tọa độ của nó.
		*/
		if ( ($ix+1)*$mx < ($jx+1)*$nx || $ix == 0 ) // nằm trên
			$spiralArray[$i][$j] = $roundFirstValue[$round] + $ix + $jx; // forget refactor this :D
		else // nằm dưới
			$spiralArray[$i][$j] = $roundFirstValue[$round] + ($n-($round)*2 + $m-($round)*2)*2 - 4 - $ix - $jx; //
	}

//finally print it to terminal.
for ($i=0; $i<$n; $i++) {
	for ($j=0; $j<$m; $j++)
		fwrite(STDOUT, str_pad($spiralArray[$i][$j], $length, ' ', STR_PAD_LEFT) );
	fwrite(STDOUT, PHP_EOL);
}