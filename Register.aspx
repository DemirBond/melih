<%@ Page Language="C#" MasterPageFile="~/MasterPage1.master" AutoEventWireup="false" CodeFile="Register.aspx.cs" Inherits="Register" title="Cardiologist's Evaluator - Registration" %>
<%@ Register Src="~/wucDate.ascx" TagPrefix="uc1" TagName="wucDate" %>
<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
<table width="100%" >
    <colgroup>
        <col width="65%" />
        <col width="35%" />
    </colgroup>
    <tr>
        <td>
            <br />
            <table width="100%" style="border:2px solid #53BAFF;" >
                <colgroup>
                    <col width="40%" style="background-color:#ECE8DF;" />
                    <col width="60%" />
                </colgroup>
                <tr>
                    <td colspan="2" style="background-color:#53BAFF;color:#FFFFFF;height:25px;"><b>New User Registration Form</b></td>   
                </tr>
                <tr >
                    <td ><asp:RequiredFieldValidator runat="server" ID="RequiredFieldValidator2" 
                        ControlToValidate="txtName"
                        Text="*"
                        ErrorMessage="- First name can not be blank"
                        Display="Dynamic"
                    ></asp:RequiredFieldValidator>
                    <b>First Name</b></td>
                    <td>
                        <asp:TextBox runat="server" ID="txtName" MaxLength="20" Columns="20"></asp:TextBox>
                    </td>
                </tr>
                <tr>
                    <td><asp:RequiredFieldValidator runat="server" ID="RequiredFieldValidator3"
                        ControlToValidate="txtSurname"
                        Text="*"
                        ErrorMessage="- Last name can not be blank"
                        Display="Dynamic"
                    ></asp:RequiredFieldValidator>
                    <b>Last Name</b></td>
                    <td>
                        <asp:TextBox runat="server" ID="txtSurname" MaxLength="20" Columns="20"></asp:TextBox>
                    </td>
                </tr>
                <tr>
                    <td><asp:RequiredFieldValidator runat="server" ID="RequiredFieldValidator4" 
                        ControlToValidate="txtEmail"
                        Text="*"
                        ErrorMessage="- E-mail can not be blank"
                        Display="Dynamic"
                    ></asp:RequiredFieldValidator>
                    <b>E-mail</b></td>
                    <td>
                        <asp:TextBox runat="server" ID="txtEmail" MaxLength="50" Columns="25"></asp:TextBox>
                    </td>
                </tr>
                <tr>
                    <td><asp:RequiredFieldValidator runat="server" ID="RequiredFieldValidator5"
                        ControlToValidate="txtPassword"
                        Text="*"
                        ErrorMessage="- Password can not be blank"
                        Display="Dynamic"
                    ></asp:RequiredFieldValidator>
                    <b>Password</b></td>
                    <td>
                        <asp:TextBox runat="server" ID="txtPassword" TextMode="Password" MaxLength="20" Columns="20"></asp:TextBox>
                    </td>
                </tr>
                <tr>
                    <td><asp:RequiredFieldValidator runat="server" ID="RequiredFieldValidator6"
                        ControlToValidate="txtPassword2"
                        Text="*"
                        ErrorMessage="- Password repeat can not be blank"
                        Display="Dynamic"
                    ></asp:RequiredFieldValidator>
                    <b>Password - repeat</b></td>
                    <td>
                        <asp:TextBox runat="server" ID="txtPassword2" TextMode="Password" MaxLength="15" Columns="15"></asp:TextBox>
                    </td>
                </tr>
                <tr>
                    <td><b>Birth Date</b></td>
                    <td>
                        <uc1:wucDate runat="server" ID="wucBirthDate"/>
                    </td>
                </tr>
                <tr>
                    <td>
                    <asp:RequiredFieldValidator runat="server" ID="RequiredFieldValidator8"
                        Text="*"
                        ErrorMessage="- Please select your gender"
                        Display="Dynamic"
                        ControlToValidate="rblGender"
                    ></asp:RequiredFieldValidator>
                    <b>Gender</b></td>
                    <td>
                        <asp:RadioButtonList runat="server" ID="rblGender" RepeatDirection="Horizontal" >
                            <asp:ListItem Text="Male" Value="M" ></asp:ListItem>
                            <asp:ListItem Text="Female" Value="F" ></asp:ListItem>
                        </asp:RadioButtonList>
                    </td>
                </tr>
                <tr>
                    <td style="background-color:#ffffff;" colspan="2">&nbsp;</td>
                </tr>
                <tr>
                    <td style="background-color:#ffffff; font-weight:bolder" colspan="2">MEDICAL SOFTWARE, L.L.C.</td>
                </tr>
                <tr>
                    <td style="background-color:#ffffff; font-weight:bolder" colspan="2">TERMS AND CONDITIONS OF USE</td>
                </tr>
                <tr>
                    <td style="background-color:#ffffff; font-weight:bolder" colspan="2">PLEASE READ THESE TERMS AND CONDITIONS OF USE CAREFULLY BEFORE USING THIS SITE.</td>
                </tr>
                <tr>
                    <td style="background-color:#ffffff;" colspan="2">By using this site, you signify your assent to these Terms and Conditions. If you do not agree to all of these Terms and Conditions of use, do not use this site!
                    </td>
                </tr>
                <tr>
                    <td style="background-color:#ffffff;" colspan="2">Medical Software, LLC. ("Medical Software") may revise and update these Terms and Conditions at any time. Your continued usage of the Medical Software website will mean you accept those changes.</td>
                </tr>
                <tr>
                    <td style="background-color:#ffffff; font-weight:bolder" colspan="2">The Site Does Not Provide Medical Advice</td>
                </tr>
                <tr>
                    <td style="background-color:#ffffff;" colspan="2">The contents of the Medical Software Site, such as software, text, graphics, images, and other material ("Software") contained on the Medical Software Site are for informational purposes only. The Software is not intended to be a substitute for professional medical advice, diagnosis, or treatment. You should always seek the advice of your physician or other qualified health provider with any questions you may have regarding a medical condition. Never disregard professional medical advice or delay in seeking it because of something you have read on the Medical Software Site or from your use of the Software!
                    </td>
                </tr>
                <tr>
                    <td style="background-color:#ffffff;" colspan="2"> If you think you may have a medical emergency, call your doctor or 911 immediately. Medical Software does not recommend or endorse any specific tests, physicians, products, procedures, opinions, or other information that may be mentioned on the Site. Reliance on any information provided by Medical Software appearing on the Site or from your use of the Software is solely at your own risk.</td>
                </tr>
                <tr>
                    <td style="background-color:#ffffff; font-weight:bolder" colspan="2">Use of Software</td>
                </tr>
                <tr>
                    <td style="background-color:#ffffff;" colspan="2">Medical Software authorizes you to download and install on a computer or mobile device a single copy of the Software on the Medical Software Site solely for your personal, noncommercial use if you include the following copyright notice: "© 2013 Medical Software, LLC. All Rights Reserved" and other copyright and proprietary rights notices that are contained in the Software. The grant of a right to non-commercial use of the Software is the only right granted herein. Any special rules for the use of Software accessible on the Medical Software Site may be included elsewhere within the Site and are incorporated into these Terms and Conditions by reference.</td>
                </tr>
                <tr>
                    <td style="background-color:#ffffff;" colspan="2">The Software is protected by patent and copyright under United States laws. Title to the Software remains with Medical Software. Any use of the Software not expressly permitted by these Terms and Conditions is a breach of these Terms and Conditions and may violate patent, copyright, trademark, and other laws. Software and features are subject to change or termination without notice in the discretion of Medical Software. All rights not expressly granted herein are reserved to Medical Software. Use of the Software on this site is licensed under U.S. Patent No. 7,306,562.</td>
                </tr>
                <tr>
                    <td style="background-color:#ffffff;" colspan="2">If you violate any of these Terms and Conditions, your permission to use the Software automatically terminates and you must immediately destroy any copies you have made of any portion of the Software.</td>
                </tr>
                <tr>
                    <td style="background-color:#ffffff; font-weight:bolder" colspan="2">Use Prohibitions</td>
                </tr>
                <tr>
                    <td style="background-color:#ffffff;" colspan="2">You agree that you shall not: (a) modify, reverse engineer, or create derivative works based on the Software; (b) make unauthorized copies of the Software; (c) rent, sell, transfer or grant any rights in and to any copy of the Software, in any form, to any third party; (d) remove any proprietary notices, labels, or marks on any copy of the Software; (e) distribute any copy of the Software to any third party; or (f) use the Software in any manner other than as expressly provided herein.</td>
                </tr>
                <tr>
                    <td style="background-color:#ffffff; font-weight:bolder" colspan="2">Ownership</td>
                </tr>
                <tr>
                    <td style="background-color:#ffffff;" colspan="2">Medical Software retains ownership of all right, title, and interest (including patent and copyright) in and to the Software, associated documentation, and all copies of the Software.  Nothing in these Terms and Conditions constitutes a transfer or conveyance of any right, title, or interest in the Software or associated documentation, or a sale of the Software, associated documentation, or copies of the Software.</td>
                </tr>
                <tr>
                    <td style="background-color:#ffffff; font-weight:bolder" colspan="2">No Warranties</td>
                </tr>
                <tr>
                    <td style="background-color:#ffffff;" colspan="2">You understand and agree that Medical Software and any services, software or information contained on or provided by the Medical Software Site is provided on an “as is” basis.  Medical Software does not make any express or implied warranties, representations or endorsements whatsoever (including without limitation warranties of title or noninfringement, or the implied warranties of merchantability or fitness for a particular purpose) with regard to the service or any merchandise information or service provided through the service.  Nothing in this agreement shall give rise to any obligation to support the Software.</td>
                </tr>
                <tr>
                    <td style="background-color:#ffffff; font-weight:bolder" colspan="2">Limitation of Liability</td>
                </tr>
                <tr>
                    <td style="background-color:#ffffff;" colspan="2">The use of the Software is entirely at your own risk, and in no event shall Medical Software be liable for any direct, indirect, incidental, consequential, special, exemplary, punitive, or any other monetary or other damages, fees, fines, penalties or liabilities arising out of or relating in any way to your use of the Software, or the Medical Software Site, and/or content or information provided herein.  Your sole and exclusive remedy for dissatisfaction with the Software is to stop using the Software.</td>
                </tr>
                <tr>
                    <td style="background-color:#ffffff; font-weight:bolder" colspan="2">Indemnity</td>
                </tr>
                <tr>
                    <td style="background-color:#ffffff;" colspan="2">You agree to defend, indemnify, and hold Medical Software, its officers, directors, members, employees, agents, licensors, and suppliers, harmless from and against any claims, actions or demands, liabilities, and settlements including without limitation, reasonable legal and accounting fees, resulting from, or alleged to result from, your violation of these Terms and Conditions.</td>
                </tr>
                <tr>
                    <td style="background-color:#ffffff; font-weight:bolder" colspan="2">Jurisdiction</td>
                </tr>
                <tr>
                    <td style="background-color:#ffffff;" colspan="2">You expressly agree that exclusive jurisdiction for any dispute with Medical Software, or in any way relating to your use of the Medical Software Site, resides in the courts of the State of Georgia and you further agree and expressly consent to the exercise of personal jurisdiction in the courts of the State of Georgia in connection with any such dispute including any claim involving Medical Software or its affiliates, subsidiaries, employees, contractors, members, officers, directors, and telecommunication providers.</td>
                </tr>
                <tr>
                    <td style="background-color:#ffffff;" colspan="2">These Terms and Conditions are governed by the substantive laws of the State of Georgia, without respect to its conflict of laws principles. If any provision of these Terms and Conditions is found to be invalid by any court having competent jurisdiction, the invalidity of such provision shall not affect the validity of the remaining provisions of these Terms and Conditions, which shall remain in full force and effect. No waiver of any of these Terms and Conditions shall be deemed a further or continuing waiver of such term or condition or any other term or condition.</td>
                </tr>
                <tr>
                    <td style="background-color:#ffffff; font-weight:bolder" colspan="2">Discontinuance of Services</td>
                </tr>
                <tr>
                    <td style="background-color:#ffffff;" colspan="2">Medical Software reserves the right to modify, discontinue, temporarily or permanently, this site, or any part thereof, at any time, with or without notice. In addition, your access to the site may be discontinued at any time if you violate the terms of this agreement or if we determine, for any other reason, that it is no longer appropriate for you to have access to the site.</td>
                </tr>
                <tr>
                    <td style="background-color:#ffffff; font-weight:bolder" colspan="2">Complete Agreement</td>
                </tr>
                <tr>
                    <td style="background-color:#ffffff;" colspan="2">Except as expressly provided in a particular "legal notice" on the Medical Software Site, these Terms and Conditions constitute the entire agreement between you and Medical Software with respect to the use of the Medical Software Site and Software.</td>
                </tr>
                <tr>
                    <td style="background-color:#ffffff;" colspan="2">&nbsp;</td>
                </tr>
                <tr>
                    <td colspan="2" align ="center" style="background-color:#53BAFF;color:#FFFFFF;">
                        <asp:Button runat="server" ID="btnSave" Text=" AGREE & REGISTER " />
                    </td>
                </tr>
            </table>
        </td>
        <td valign="top" style="padding-left:5px;">
            <br />
            <asp:Label runat="server" ID="lblMessage" EnableViewState="false"></asp:Label>
            <asp:ValidationSummary runat="server" ID="ValidationSummary" HeaderText="Please check the fields below" Font-Bold="true" />
        </td>
    </tr>
</table>
</asp:Content>

