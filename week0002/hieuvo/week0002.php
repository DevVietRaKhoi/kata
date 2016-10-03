<?php

$n = 4; // columns
$m = $M = 4; // rows
$spiral = array_fill(0, $m, array_fill(0, $n, 'x'));
$x = 0;
$y = -1;
$v = 1;

$path = [];

function move($x, $y, $direction) {
    $moves = [
        'right' => [0, 1],
        'down' => [1, 0],
        'left' => [0, -1],
        'up' => [-1, 0]
    ];
    
    return [
        $x+$moves[$direction][0],
        $y+$moves[$direction][1],
    ];
}

while ($n >= 1 && $m >= 1) {
    $path[] = 'right';
    
    for ($i=1; $i<=$n-1; $i++) $path[] = 'right';
    
    if ($m > 1) { 
        for ($i=1; $i<=$m-1; $i++) $path[] = 'down';
        for ($i=1; $i<=$n-1; $i++) $path[] = 'left';
        for ($i=1; $i<=$m-2; $i++) $path[] = 'up';
    }
    
    $n -= 2;
    $m -= 2;
}


foreach ($path as $direction) {
    list($x, $y) = move($x, $y, $direction);
    $spiral[$x][$y] = $v++;
}

$stdout = fopen('php://stdout', 'w');

$i = 1;
foreach ($spiral as $row) {
    fwrite($stdout, implode(' ', $row));
    if ($i++ < $M) { 
        fwrite($stdout, "\n");
    }
}


