<?php
namespace FinTech;

class Account
{
    protected $name;
    protected $amount = 0.00;

    public function __construct($name, $amount)
    {
        $this->name = $name;
        $this->amount = (float) $amount;
    }

    public function deposit($amount)
    {
        $this->amount += $amount;
    }

    public function withdraw($amount)
    {
        if ($this->amount - $amount >= 0) {
            $this->amount -= $amount;
            return true;
        }
        return false;
    }
}
