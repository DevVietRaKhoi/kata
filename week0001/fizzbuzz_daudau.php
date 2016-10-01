<?php
	$i = 1;
	$fizz = 'fizz'.'<br/>'; $buzz = 'buzz'.'<br/>';
	$a = 3; $b =5;
	$ab = $a*$b;
	while ($i++ < 100){
		echo $i%$ab ? $i%$a ? $i%$b ? false : $buzz : $fizz : $fizz.$buzz;
	}