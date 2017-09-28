using Microsoft.VisualBasic;
using System;
using System.Collections;
using System.Collections.Generic;
using System.Data;
using System.Diagnostics;
using DataService;
using System.Data.OleDb;

public partial class Register : System.Web.UI.Page
{

    protected void btnSave_Click(object sender, System.EventArgs e)
    {
        if (string.IsNullOrEmpty(txtEmail.Text.Trim()) | string.IsNullOrEmpty(txtName.Text.Trim()) | string.IsNullOrEmpty(txtSurname.Text.Trim()) | string.IsNullOrEmpty(txtPassword.Text.Trim()) | string.IsNullOrEmpty(txtPassword2.Text.Trim()) | string.IsNullOrEmpty(rblGender.SelectedValue))
        {
            return;
        }
        if (CheckUserEmailIsExist(txtEmail.Text.Trim()))
        {
            lblMessage.Text = "This email address already used before. Please try another one.";
            return;
        }
        if (txtPassword.Text.Length < 4)
        {
            lblMessage.Text = "Password must be at least 4 character.";
            return;
        }
        if (txtPassword.Text != txtPassword2.Text)
        {
            lblMessage.Text = "Please check your password";
            txtPassword.Text = "";
            txtPassword2.Text = "";
            return;
        }
        if (wucBirthDate.IsValidDate == false)
        {
            lblMessage.Text = "Birth date is invalid.Please reenter your birth date";
            return;
        }
        int retVal = RegisterSave();
        if (retVal == 0)
        {
            Response.Redirect("~/RegisterOk.aspx");
        }
    }
    protected int RegisterSave()
    {
        dataWork dw = new dataWork(dbNames.OLEDB);
        dw.ConnectionString = CVDevaluator.SharedFunctions.GetConnStr("ConnString3");
        dataCommand dtCmd = new dataCommand();
        clsCrypto Crypto = new clsCrypto();
        dtCmd.commandExecuteType = commandExecuteType.INSERTORUPDATE;
        dtCmd.OleCommandText = "INSERT INTO USER0([EMAIL],[PASSWORD],[NAME],[SURNAME],[BIRTHDATE],[GENDER],[WORKADDRESS],[WORKPOSTCODE],[JOBTITLE],[AREAOFINTEREST]) " + "VALUES(@EMAIL,@PASSWORD,@NAME,@SURNAME,@BIRTHDATE,@GENDER,@WORKADDRESS,@WORKPOSTCODE,@JOBTITLE,@AREAOFINTEREST)";
        dtCmd.Parameters.Add(new DataService.Param("@EMAIL", txtEmail.Text, dbTypes.CHAR));
        dtCmd.Parameters.Add(new DataService.Param("@PASSWORD", Crypto.Encrypt(txtPassword.Text), dbTypes.CHAR));
        dtCmd.Parameters.Add(new DataService.Param("@NAME", txtName.Text, dbTypes.CHAR));
        dtCmd.Parameters.Add(new DataService.Param("@SURNAME", txtSurname.Text, dbTypes.CHAR));
        dtCmd.Parameters.Add(new DataService.Param("@BIRTHDATE", wucBirthDate.GetDate, dbTypes.DATE));
        dtCmd.Parameters.Add(new DataService.Param("@GENDER", rblGender.SelectedValue, dbTypes.CHAR));
        dtCmd.Parameters.Add(new DataService.Param("@WORKADDRESS", "N/A", dbTypes.CHAR));
        dtCmd.Parameters.Add(new DataService.Param("@WORKPOSTCODE", "N/A", dbTypes.CHAR));
        dtCmd.Parameters.Add(new DataService.Param("@JOBTITLE", "N/A", dbTypes.CHAR));
        dtCmd.Parameters.Add(new DataService.Param("@AREAOFINTEREST", "N/A", dbTypes.CHAR));
        dw.ExecuteDataCommand(dtCmd);

        if (dtCmd.commandResult == null)
        {
            return -1;
        }
        if (dtCmd.commandResult.ToString() != "")
        {
            return 0;
        }
        else
        {
            return -1;
        }
    }
    protected bool CheckUserEmailIsExist(string strEmail)
    {
        dataWork dw = new dataWork(dbNames.OLEDB);
        dw.ConnectionString = CVDevaluator.SharedFunctions.GetConnStr("ConnString3");
        dataCommand dtCmd = new dataCommand();
        clsCrypto Crypto = new clsCrypto();
        dtCmd.commandExecuteType = commandExecuteType.SELECT_DATATABLE;
        dtCmd.OleCommandText = "SELECT * FROM USER0 WHERE [EMAIL]=@EMAIL";
        dtCmd.Parameters.Add(new DataService.Param("@EMAIL", strEmail, dbTypes.CHAR));

        int intRetval = dw.ExecuteDataCommand(dtCmd);
        if (dtCmd.commandResult.GetType() is DataTable)
        {
            return false;
        }
        if (((System.Data.DataTable)dtCmd.commandResult).Rows.Count == 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}

