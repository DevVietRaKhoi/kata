<?php
/*
 * This file is part of the FinTech.
 */

namespace FinTech;

/**
 * Class Action
 * @package FinTech
 */
class Action
{
    /**
     * @var string
     */
    protected $action;

    /**
     * @var string
     */
    protected $name;

    /**
     * @var double
     */
    protected $amount;

    /**
     * @var AccountManager
     */
    protected $accountManager;

    /**
     * @var string
     */
    protected $output;

    const ACTION_ADD_CLIENT = 'A';
    const ACTION_DEPOSIT_MONEY = 'D';
    const ACTION_WITHDRAW_MONEY = 'W';

    /**
     * Action constructor.
     * @param $action
     * @param $name
     * @param $amount
     * @param AccountManager $accountManager
     */
    public function __construct($action, $name, $amount, AccountManager $accountManager)
    {
        $this->action = $action;
        $this->name = $name;
        $this->amount = $amount;
        $this->accountManager = $accountManager;
        
        switch ($this->action) {
            case self::ACTION_ADD_CLIENT:
                $this->output = $this->actionAddAccount();
                break;
            case self::ACTION_DEPOSIT_MONEY:
                $this->output = $this->actionDepositMoney();
                break;
            case self::ACTION_WITHDRAW_MONEY:
                $this->output = $this->actionWithdrawMoney();
                break;
            default:
                $this->output = 'Invalid';
                break;
        }
    }

    /**
     * @return string
     */
    public function performAction()
    {
        return $this->output;
    }

    /**
     * @return string
     */
    protected function actionAddAccount()
    {
        return ($this->accountManager->addAccount($this->name, $this->amount)) ? 'True' : 'False';
    }

    /**
     * @return string
     */
    protected function actionDepositMoney()
    {
        return ($this->accountManager->depositMoney($this->name, $this->amount)) ? 'True' : 'False';
    }

    /**
     * @return string
     */
    protected function actionWithdrawMoney()
    {
        return ($this->accountManager->withdrawMoney($this->name, $this->amount)) ? 'True' : 'False';
    }
}
