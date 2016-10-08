<?php
// FUNCTION
function checkValidInput($input)
{
    if (!is_numeric($input) || $input <= 0) {
        exit;
    }
}

// MAIN
$handleIn = fopen("php://stdin", "r");
$handleOut = fopen('php://stdout', 'w');

fwrite($handleOut, "Input N:");
fscanf($handleIn, "%d", $n);
checkValidInput($n);

fwrite($handleOut, "Input M:");
fscanf($handleIn, "%d", $m);
checkValidInput($m);

$length = $n * $m;
$left = 0;
$right = $m-1;
$up = 0;
$down = $n-1;
$i = 0;
$j = 0;
$direction = 'right';
$result = [];

for ($l=1; $l<=$length; $l++) {
    $result[$i][$j] = $l;
    switch ($direction) {
        case 'right':
            $j++;
            if ($j == $right) {
                $direction = 'down';
                $up++;
            }
            break;
        case 'down':
            $i++;
            if ($i == $down) {
                $direction = 'left';
                $right--;
            }
            break;
        case 'left':
            $j--;
            if ($j == $left) {
                $direction = 'up';
                $down--;
            }
            break;
        case 'up':
            $i--;
            if ($i == $up) {
                $direction = 'right';
                $left++;
            }
            break;
    }
}

foreach ($result as &$row) {
    ksort($row);
    foreach ($row as $col) {
        fwrite($handleOut, $col." ");
    }
    fwrite($handleOut, PHP_EOL);
}
