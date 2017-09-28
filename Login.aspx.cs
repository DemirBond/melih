using System;
using System.Collections.Generic;
//using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using CVDevaluator;

public partial class Login : System.Web.UI.Page
{
    protected void btnLogin_Click(object sender, EventArgs e)
    {

        if (string.IsNullOrEmpty(txtEmail.Text.Trim()) || string.IsNullOrEmpty(txtPassword.Text.Trim()))
        {
            return;
        }
        string strRdrUrl = Request["Rdr"];
        if (CVDevaluator.SharedFunctions.LoginUser(txtEmail.Text.Trim(), txtPassword.Text.Trim()))
        {
            if (!string.IsNullOrEmpty(strRdrUrl))
            {
                Response.Redirect(strRdrUrl);
            }
            else
            {
                Response.Redirect("~/");
            }
        }
    }
}
