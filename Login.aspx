<%@ Page Language="C#" MasterPageFile="~/MasterPage1.master" AutoEventWireup="false" CodeFile="Login.aspx.cs" Inherits="Login" title="Cardiologist's Evaluator" %>
<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
<table width="100%">
    <colgroup>
        <col width="50%" />
        <col width="50%" />
    </colgroup>
    <tr>
        <td valign="top">
            <table width="100%">
                <tr>
                    <td>If you are registered user, you can enter the evaluation system by entering your email address and password at the form on right side.
                        <br /><br />
                        If you are not registered yet, please enter the new user registration form by clicking here.
                        <br /><br />
                    </td>
                </tr>
                <tr>
                    <td align="center">
                        <table width="80%" style="border:solid 2px #3EB1FF;">
                            <tr>
                                <td style="background-color:#53BAFF;height:35px;color:#004D80;text-align:center;">
                                    <a href="Register.aspx">
                                    <b>Click here to register</b>
                                    </a>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
        </td>
        <td valign="top" align="right">
            <table width="300" style="text-align:left;background-image:url('img/picture2.png');background-repeat:no-repeat;" >
                <tr>
                    <td colspan="2">
                        <b>Sign-in Form</b>
                    </td>
                </tr>
                <tr>
                    <td>
                    <asp:RequiredFieldValidator runat="server" ID="RequiredFieldValidator1" 
                    Display="Dynamic" 
                    Text="*"
                    ErrorMessage="E-mail field can not be blank"
                    ControlToValidate="txtEmail"
                    ></asp:RequiredFieldValidator>
                    E-mail</td>
                    <td>
                        <asp:TextBox runat="server" ID="txtEmail"></asp:TextBox>
                    </td>
                </tr>
                <tr>
                    <td>
                    <asp:RequiredFieldValidator runat="server" ID="RequiredFieldValidator" 
                    Display="Dynamic" 
                    Text="*"
                    ErrorMessage="Password field can not be blank"
                    ControlToValidate="txtPassword"
                    ></asp:RequiredFieldValidator>
                    Password</td>
                    <td>
                        <asp:TextBox runat="server" ID="txtPassword" TextMode="Password"></asp:TextBox>
                    </td>
                </tr>
                <tr>
                    <td >
                        <asp:CheckBox runat="server" ID="cbRememberMe" Text="Remember me" />
                    </td>
                    <td >
                        Remind my password
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <asp:Button runat="server" ID="btnLogin" Text="  Enter  " 
                            onclick="btnLogin_Click" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <asp:ValidationSummary runat="server" ID="ValidationSummary1" HeaderText="Please check fields below," />
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>
</asp:Content>
