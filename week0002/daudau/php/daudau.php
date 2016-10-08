<?php
fwrite(STDOUT, 'Input N: ');
fscanf(STDIN, "%d", $n);

fwrite(STDOUT, 'Input M: ');
fscanf(STDIN, "%d", $m);

$min = $m > $n ? $n : $m;
$max = $min == $m ? $n : $m;
$circle = ceil($min/2.0);
$length = strlen($n*$m) + 1;
$roundFirstValue = array();

$roundFirstValue[0] = 1;
$tmpValue = 0;
for ($i =1; $i<$circle; $i++) {
	$roundFirstValue[$i] = $roundFirstValue[$i-1] + ($n-($i-1)*2 + $m-($i-1)*2)*2 - 4;
}

$spiralArray = array();

for ($i=0; $i<$n; $i++)
	for ($j=0; $j<$m; $j++) {
		$tmpi = $i > ($n-1)/2 ? $n - 1 - $i : $i;
		$tmpj = $j > ($m-1)/2 ? $m - 1 - $j : $j;
		$round = $tmpi > $tmpj ? $tmpj : $tmpi;  //find round position of a coordiante
		//resize square
		$ix = $i - $round;
		$jx = $j - $round;
		$nx = $n - $round*2;
		$mx = $m - $round*2;  
		//calculate value at a coordinate. this is mathematic solutions, you must understand this formular.
		//my english is not good, but i willtry to explain this.
		//when coordinate of a point belong the up part of a rectange by diagonal line. we use formular in (if),else is revert of it.
		if ( ($ix+1)*($mx) < ($jx+1)*($nx) || $ix == 0 )
			$spiralArray[$i][$j] = $roundFirstValue[$round] + $i-$round + $j-$round;
		else
			$spiralArray[$i][$j] = $roundFirstValue[$round] + ($n-($round)*2 + $m-($round)*2)*2 -4 - $i+$round - $j+$round;
	}

for ($i=0; $i<$n; $i++) {
	for ($j=0; $j<$m; $j++)
		fwrite(STDOUT, str_pad($spiralArray[$i][$j], $length, ' ', STR_PAD_LEFT) );
	fwrite(STDOUT, PHP_EOL);
}