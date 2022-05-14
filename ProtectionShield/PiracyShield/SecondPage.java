package PiracyShield;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.*;

class SecondPage
{
	private JFrame window;
	private Log log;

	public SecondPage(Memory memory)
	{
		window = memory.window;
		log = memory.log;
		
//		log.writeLog("Show License Agreement");
//		window = new JFrame();
//		window.setTitle("Software Piracy Protection System");
//		window.getContentPane().setBackground(Color.WHITE);
//		window.setIconImage(Toolkit.getDefaultToolkit().getImage(FirstPage.class.getResource("/Images/shield.png")));
//		window.getContentPane().setLayout(null);
//		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		window.setBounds(420, 50, 700, 500);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(10, 88, 664, 8);
		window.getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(10, 399, 664, 8);
		window.getContentPane().add(separator_1);

		JLabel lblNewLabel = new JLabel("License Agreement");
		lblNewLabel.setFont(new Font("Alice", Font.BOLD, 24));
		lblNewLabel.setBounds(22, 10, 547, 27);
		window.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Please read the license agreement carefully.");
		lblNewLabel_1.setFont(new Font("Alice", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(22, 47, 550, 27);
		window.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(SecondPage.class.getResource("/Images/shieldIcon.png")));
		lblNewLabel_2.setBounds(594, 10, 80, 70);
		window.getContentPane().add(lblNewLabel_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 106, 640, 220);
		window.getContentPane().add(scrollPane);

		JTextArea txtrSoftwareLicenseAgreement = new JTextArea();
		txtrSoftwareLicenseAgreement.setLineWrap(true);
		txtrSoftwareLicenseAgreement.setFont(new Font("Alice", Font.PLAIN, 16));
		txtrSoftwareLicenseAgreement.setText(
				"Software License Agreement\nThis Software License Agreement is made on [AGREEMENT DATE] between [LICENSOR NAME], a [CORPORATE JURISDICTION] corporation with its principal place of business at [LICENSOR ADDRESS] (\"[PARTY A]\") and [LICENSEE NAME], a [CORPORATE JURISDICTION] corporation with its principal place of business at [LICENSEE ADDRESS] (\"[PARTY B]\").\nThe parties agree to the terms of this agreement.\n1. License Grant\n\t1.1. Software License. [PARTY A] hereby grants to [PARTY B] [an exclusive / a non-exclusive], [transferable / non-transferable], [sublicensable / non-sublicensable], [revocable / irrevocable] license (the \"[DELIVERABLE]\") to use the Software.\n\t1.2. No Other Rights. [PARTY A] reserves for itself all other rights and interest not explicitly granted under this agreement.\n\t1.3. Software. \"Software\" means [SHORT DESCRIPTION OF SOFTWARE] [the software described in the [ATTACHMENT], attached to this agreement].\n2. Training and Support Services\n\t2.1. Training. [PARTY A] shall, at [PARTY A]'s expense, provide [PARTY B]'s employees with the initial training services necessary and desirable to operate the Software, as further described in the [ATTACHMENT], attached to this agreement, at [PARTY B]'s offices and on days and times the parties agree to in writing.\n\t2.2. Support\n\t\t(a) Initial Support. For the [12] month period beginning on the Effective Date, and at [PARTY A]'s own expense, [PARTY A] shall provide [PARTY B] with \n\t\t\t(i) telephone or electronic support during [PARTY A]'s normal business hours in order to help [PARTY B] locate and correct problems with the Software, and\n\t\t\t(ii) internet-based support system generally available seven days a week, twenty-four hours a day. \n\t\t(b) Renewed Support. After the initial [12] month support period, [PARTY B] may elect to renew [PARTY A]'s support services under this paragraph [SUPPORT] for additional [12] month periods, at [PARTY A]'s then-current service rates.\n3. Updates and Maintenance Services\n\t3.1. Updates. [PARTY A] shall provide [PARTY B], at [PARTY A]'s sole expense, with all updates, extensions, enhancement, modifications, and other changes [PARTY A] makes or adds to the Software and which [PARTY A] offers to other licensees of the Software.\n\t3.2. Fixes and Patches. [PARTY A] shall provide [PARTY B], at [PARTY A]'s sole expense, with bug fixes and code corrections to correct Software malfunctions and defects in order to bring the Software into substantial conformity with its operating specifications.\n\t3.3. Exceptions. [PARTY A] may, but will not be required to, provide these maintenance services if [PARTY B] has modified the Software or is in default.\n4. License Fees. [PARTY B] shall pay [PARTY A] the license fee [of $[LICENSE FEE] / listed in [ATTACHMENT]] (the \"License Fee\").\n5. License Fees\n\t5.1. License Fee Paid in Full. [PARTY B] shall pay the License Fee to [PARTY A]\n\t\t(a) in full,\n\t\t(b) due on [DATE, MONTH],\n\t\t(c) in immediately available funds, and\n\t\t(d) to the account [PARTY A] lists immediately below:\n\t\t\tAccount Number:\n\t\t\tRouting Number:\n6. Taxes. Payment amounts under this agreement do not include Taxes, and [PARTY B] shall pay all Taxes applicable to payments between the parties under this agreement. \n7. Interest on Late Payments.  Any amount not paid when due will bear interest from the due date until paid at a rate equal to [1]% per month ([12.68]% annually) or the maximum allowed by Law, whichever is less.\n8. Restricted Uses. [PARTY B] will not\n\t8.1. distribute, license, loan, or sell the Software or other content that is contained or displayed in it,\n\t8.2. modify, alter, or create any derivative works from the Software,\n\t8.3. reverse engineer, decompile, decode, decrypt, disassemble, or derive any source code from the Software,\n\t8.4. remove, alter, or obscure any copyright, trademark, or other proprietary rights notice on or in the Software.\n9. Permitted Uses\n\t9.1. Installation. [PARTY B] may install and use the Software solely for [personal, non-commercial][internal business] use.\n\t9.2. Evaluation Use. If [PARTY B] has ordered an evaluation license, [PARTY B] may use the Software only for evaluation purposes and only during the applicable evaluation period. \n\t9.3. Server Deployment. [PARTY B] may install [NUMBER OF SERVER COPIES] of copies of the Software on an internal file server for purposes of downloading and installing the Software on licensed computers within the same internal network.\n\t9.4. Home Use. [PARTY B] may install a copy of the Software on a personal or home computer, provided both copies of the Software are not used at the same time.\n\t9.5. Backup and Archival Copies. [PARTY B] may make one copy of the Software solely for backup or archival purposes.\n10. Term. This agreement begins on [the Effective Date / [DATE, MONTH]], and will continue until terminated (the \"Term\").\n11. Representations\n\t11.1. Mutual Representations\n\t\t(a) Existence. The parties are corporations incorporated and existing under the laws of the jurisdictions of their respective incorporation.\n\t\t(b) Authority and Capacity. The parties have the authority and capacity to enter into this agreement.\n\t\t(c) Execution and Delivery. The parties have duly executed and delivered this agreement.\n\t\t(d) Enforceability. This agreement constitutes a legal, valid, and binding obligation, enforceable against the parties according to its terms.\n\t\t(e) No Conflicts. Neither party is under any restriction or obligation that the party could reasonably expect might affect the party's performance of its obligations under this agreement.\n\t\t(f) No Breach. Neither party\u2019s execution, delivery, or performance of its obligations under this agreement will breach or result in a default under\n\t\t\t(i) its articles, bylaws, or any unanimous shareholders agreement,\n\t\t\t(ii) any Law to which it is subject,\n\t\t\t(iii) any judgment, Order, or decree of any Governmental Authority to which it is subject, or\n\t\t\t(iv) any agreement to which it is a party or by which it is bound.\n\t\t(g) Permits, Consents, and Other Authorizations. Each party holds all Permits and other authorizations necessary to\n\t\t\t(i) own, lease, and operate its properties, and\n\t\t\t(ii) conduct its business as it is now carried on.\n\t\t(h) No Disputes or Proceedings. [Except as disclosed in the parties respective Disclosure Schedules] There are no Legal Proceedings pending, threatened, or foreseeable against either party, which would affect that party\u2019s ability to complete its obligations under this agreement.\n\t\t(i) No Bankruptcy. Neither party has taken or authorized any proceedings related to that party\u2019s bankruptcy, insolvency, liquidation, dissolution, or winding up.\n\t11.2. [PARTY A]'s Representations\n\t\t(a) Disclosure Schedule. [PARTY A]'s Disclosure Schedule lists any exceptions to its representations.\n\t\t(b) Ownership of Intellectual Property. [Except as disclosed in [PARTY A]'s Disclosure Schedule] [PARTY A]\n\t\t\t(i) is the owner of all Intellectual Property rights included in the Software and granted under in the [DELIVERABLE], and\n\t\t\t(ii) has the exclusive right to grant the [DELIVERABLE].\n\t\t(c) Maintenance of Intellectual Property. [PARTY A] has properly maintained all its Intellectual Property rights licensed under the [DELIVERABLE], including paying all applicable registration and maintenance fees.\n\t\t(d) No Prior Grant or Transfer. [PARTY A] has not granted and is not obligated to grant any license to any third party that would conflict with the [DELIVERABLE] under this agreement\n\t\t(e) No Infringement. [To [PARTY A]'s Knowledge,] The Software does not infringe the Intellectual Property rights or other rights of any third party.\n\t\t(f) No Third Party Infringement. [Except as disclosed in [PARTY A]'s Disclosure Schedule] To [PARTY A]'s Knowledge, no third party is infringing its Intellectual Property rights in the Software.\n\t\t(g) Not in Public Domain. The Software is not in the public domain.\n12. No Warranty\n\t12.1. \"As-Is\". The [Licensed] Software is provided \"as is,\" with all faults, defects, bugs, and errors.\n\t12.2. No Warranty. Unless otherwise listed in this agreement,\n\t\t(a) [PARTY A] does not make any warranty regarding the [Licensed] Software, which includes that \n\t\t(b) [PARTY A] disclaims to the [fullest] extent authorized by Law any and all [other] warranties, whether express or implied, including any implied warranties of [title, non-infringement, quiet enjoyment, integration,] merchantability or fitness for a particular purpose.\n13. Intellectual Property. [PARTY A] will retain exclusive interest in and ownership of its Intellectual Property rights in and to the Software and expressly reserves all rights not expressly granted under this agreement.\n14. Compliance with Laws. Each party shall\n\t14.1. comply with all applicable Laws [relating to [SUBJECT MATTER OF AGREEMENT]], and\n\t14.2. notify the other party if it becomes aware of any non-compliance in connection with this section.\n15. Confidentiality Obligations. The parties shall continue to be bound by the terms of the non-disclosure agreement between the parties, dated [DATE] and attached to this agreement on [ATTACHMENT].\n16. Publicity\n\t16.1. Consent. Neither party will use the other party's name, logo, or trademarks, or issue any press release or public announcement regarding this agreement, without the other party's written consent, unless specifically permitted under this agreement or required by Law.\n\t16.2. Cooperation. The parties shall cooperate to draft all appropriate press releases and other public announcements relating to the subject matter of this agreement and the relationship between the parties.\n\t16.3. No Unreasonable Delay. The parties will not unreasonably withhold or delay their consent to press releases or public announcements.\n17. Termination\n\t17.1. Termination on Notice. Either party may terminate this agreement for any reason on [TERMINATION NOTICE BUSINESS DAYS] Business Days\u2019 notice to the other party.\n\t17.2. Termination for Material Breach. Each party may terminate this agreement with immediate effect by delivering notice of the termination to the other party, if\n\t\t(a) the other party fails to perform, has made or makes any inaccuracy in, or otherwise materially breaches, any of its obligations, covenants, or representations, and\n\t\t(b) the failure, inaccuracy, or breach continues for a period of [BREACH CONTINUATION DAYS] Business Days' after the injured party delivers notice to the breaching party reasonably detailing the breach.\n18. Effect of Termination\n\t18.1. Payment Obligations. On the expiration or termination of this agreement, each party shall\n\t\t(a) pay any amounts it owes to the other party, including payment obligations for services already rendered, work already performed, goods already delivered, or expenses already incurred, and\n\t\t(b) refund any payments received but not yet earned, including payments for services not rendered, work not performed, or goods not delivered, expenses forwarded.\n\t18.2. Termination of License Grant. On the expiration or termination of this agreement the [DELIVERABLE] granted under this agreement will terminate with immediate effect.\n19. Return of Property. On termination or expiration of this agreement, or on [PARTY A]'s request, [PARTY B] shall\n\t19.1. return to [PARTY A] all originals of the information, documents, equipment, files, and other property, including Intellectual Property, it received from [PARTY A],\n\t19.2. destroy all copies of [PARTY A]'s of the information, documents, equipment, files, and other property, including Intellectual Property, it made, and\n\t19.3. on [PARTY A]'s request, certify to [PARTY A] in writing that it destroyed all these copies.\n20. Indemnification\n\t20.1. Indemnification by [PARTY B]. [PARTY B] (as an indemnifying party) shall indemnify [PARTY A] (as an indemnified party) against all losses and expenses in connection with any proceeding arising out of \n\t\t(a) [PARTY B]'s use of the Software, and\n\t\t(b) [PARTY B]'s unauthorized customization, modification, or other alterations to the Software, including claims that its customization, modification, or other alterations infringe a third party's Intellectual Property rights, \n\t20.2. Mutual Indemnification. Each party (as an indemnifying party) shall indemnify the other (as an indemnified party) against all losses in connection with any proceeding arising out of the indemnifying party's willful misconduct or gross negligence.\n\t20.3. Notice and Failure to Notify\n\t\t(a) Notice Requirement. Before bringing a claim for indemnification, the indemnified party shall\n\t\t\t(i) notify the indemnifying party of the indemnifiable proceeding, and\n\t\t\t(ii) deliver to the indemnifying party all legal pleadings and other documents reasonably necessary to indemnify or defend the indemnifiable proceeding.\n\t\t(b) Failure to Notify. If the indemnified party fails to notify the indemnifying party of the indemnifiable proceeding, the indemnifying will be relieved of its indemnification obligations to the extent it was prejudiced by the indemnified party's failure.\n\t20.4. Exclusive Remedy. The parties' right to indemnification is the exclusive remedy available in connection with the indemnifiable proceedings described in this section [INDEMNIFICATION].\n21. Limitation on Liability. Neither party will be liable for breach-of-contract damages that are remote or speculative, or that the breaching party could not reasonably have foreseen on entry into this agreement.\n22. General Provisions\n\t22.1. Entire Agreement. The parties intend that this agreement, together with all attachments, schedules, exhibits, and other documents that both are referenced in this agreement and refer to this agreement,\n\t\t(a) represent the final expression of the parties' intent relating to the subject matter of this agreement,\n\t\t(b)  contain all the terms the parties agreed to relating to the subject matter, and\n\t\t(c) replace all of the parties' previous discussions, understandings, and agreements relating to the subject matter of this agreement.\n\t22.2. Counterparts\n\t\t(a) Signed in Counterparts. This agreement may be signed in any number of counterparts.\n\t\t(b) All Counterparts Original. Each counterpart is an original.\n\t\t(c) Counterparts Form One Document. Together, all counterparts form one single document.\n\t22.3. Amendment. This agreement can be amended only by a writing signed by both parties.\n23. Relationship of the Parties\n\t23.1. No Relationship. Nothing in this agreement creates any special relationship between the parties, such as a partnership, joint venture, or employee/employer relationship between the parties.\n\t23.2. No Authority. Neither party will have the authority to, and will not, act as agent for or on behalf of the other party or represent or bind the other party in any manner.\n\t23.3. Assignment. Neither party may assign this agreement or any of their rights or obligations under this agreement without the other party's written consent.\n\t23.4. Notices\n\t\t(a) Method of Notice. The parties shall give all notices and communications between the parties in writing by (i) personal delivery, (ii) a nationally-recognized, next-day courier service, (iii) first-class registered or certified mail, postage prepaid[, (iv) fax][, or (v) electronic mail] to the party's address specified in this agreement, or to the address that a party has notified to be that party's address for the purposes of this section.\n\t\t(b) Receipt of Notice. A notice given under this agreement will be effective on\n\t\t\t(i) the other party's receipt of it, or\n\t\t\t(ii) if mailed, the earlier of the other party's receipt of it and the [fifth] business day after mailing it. \n\t23.5. Governing Law and Consent to Jurisdiction and Venue\n\t\t(a) Governing Law. This agreement, and any dispute arising out of the [SUBJECT MATTER OF THE AGREEMENT], shall be governed by the laws of the State of [GOVERNING LAW STATE].\n\t\t(b) Consent to Jurisdiction. Each party hereby irrevocably consents to the [exclusive, non-exclusive] jurisdiction and venue of any [state or federal] court located within [VENUE COUNTY] County, State of [VENUE STATE], in connection with any matter arising out of this [agreement / plan] or the transactions contemplated under this [agreement / plan].\n\t\t(c) Consent to Service. Each party hereby irrevocably\n\t\t\t(i) agrees that process may be served on it in any manner authorized by the Laws of the State of [GOVERNING LAW STATE], and \n\t\t\t(ii) waives any objection which it might otherwise have to service of process under the Laws of the State of [GOVERNING LAW STATE].\n\t23.6. Dispute Resolution\n\t\t(a) Arbitration. Any dispute or controversy arising out of this agreement and [SUBJECT MATTER OF THE AGREEMENT] will be settled by arbitration in [STATE], according to the rules of the American Arbitration Association then in effect, and by [NUMBER OF ARBITRATORS] arbitrators[s].\n\t\t(b) Judgment. Judgment may be entered on the arbitrator's award in any court having jurisdiction.\n\t\t(c) Arbitrator's Authority. The arbitrator will not have the power to award any punitive [or consequential] damages.\n24. Equitable Relief\n\t24.1. Acknowledgment of Irreparable Harm. Each party acknowledges that their breach or threatened breach of their obligations under sections [CONFIDENTIALITY], [NON-COMPETITION], and [NON-SOLICITATION][INCLUDE OTHER SPECIFIC OBLIGATIONS] would result in irreparable harm to the other party that cannot be adequately relieved by money damages alone.\n\t24.2. Intent to Allow for Equitable Remedies. Accordingly, the parties hereby acknowledge their mutual intent that after any breach of the obligations listed in the paragraph directly above, the non-breaching party may request any applicable equitable remedies from a court, including injunctive relief, without the need for that party to post any security.\n\t24.3. Waiver\n\t\t(a) Affirmative Waivers. Neither party's failure or neglect to enforce any rights under this agreement will be deemed to be a waiver of that party's rights.\n\t\t(b) Written Waivers. A waiver or extension is only effective if it is in writing and signed by the party granting it.\n\t\t(c) No General Waivers. A party's failure or neglect to enforce any of its rights under this agreement will not be deemed to be a waiver of that or any other of its rights.\n\t\t(d) No Course of Dealing. No single or partial exercise of any right or remedy will preclude any other or further exercise of any right or remedy.\n\t24.4. Force Majeure. Neither party will be liable for performance delays nor for non-performance due to causes beyond its reasonable control, except for payment obligations.\n\t24.5. Severability. If any part of this agreement is declared unenforceable or invalid, the remainder will continue to be valid and enforceable.\n\t24.6. Survival. The parties' obligations under sections [CONFIDENTIALITY OBLIGATIONS], [NON-COMPETITION OBLIGATION], and [EFFECT OF TERMINATION] will survive the [TERMINATION, EXPIRATION, CLOSING DATE] of this agreement.\n\t24.7. Headings. The section headings contained in this agreement are for reference purposes only and shall not affect the meaning or interpretation of this agreement.\n\t24.8. Attorney Fees. If either party brings an Action to enforce their rights under this agreement, the prevailing party may recover its expenses (including reasonable attorneys' fees) incurred in connection with the Action and any appeal from the losing party.\nThis agreement has been signed by the parties.\n[PARTY A NAME]\nName: [PARTY A SIGNATORY NAME]\nTitle: [PARTY A SIGNATORY TITLE]\n[PARTY B NAME]\nName: [PARTY B SIGNATORY NAME]\nTitle: [PARTY B SIGNATORY TITLE]");
		txtrSoftwareLicenseAgreement.setEditable(false);
		txtrSoftwareLicenseAgreement.setCaretPosition(0);
		scrollPane.setViewportView(txtrSoftwareLicenseAgreement);

		JButton btnNext = new JButton("Next >");
		btnNext.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(btnNext.isEnabled())
				{
					log.writeLog("Goto ThirdPage");
					memory.radioSelection = 1;
					window.getContentPane().removeAll();
					window.repaint();
					new ThirdPage(memory);
				}
			}
		});
		btnNext.setFont(new Font("Alice", Font.BOLD, 16));
		btnNext.setBounds(474, 410, 95, 27);
		btnNext.setEnabled(false);
		window.getContentPane().add(btnNext);

		JRadioButton radioYes = new JRadioButton("I accept the terms in the license agreement.");
		radioYes.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				log.writeLog("user selected <I accept>");
				btnNext.setEnabled(true);
			}
		});
		radioYes.setFont(new Font("Alice", Font.PLAIN, 18));
		radioYes.setBackground(Color.WHITE);
		radioYes.setBounds(22, 332, 640, 21);
		window.getContentPane().add(radioYes);
		
		if(memory.radioSelection == 1)
		{
			radioYes.setSelected(true);
		}

		JRadioButton radioNo = new JRadioButton("I do not accept the terms in the license agreement.");
		radioNo.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				log.writeLog("user selected <I do not accept>");
				btnNext.setEnabled(false);
			}
		});

		radioNo.setFont(new Font("Alice", Font.PLAIN, 18));
		radioNo.setBackground(Color.WHITE);
		radioNo.setBounds(22, 355, 640, 21);
		window.getContentPane().add(radioNo);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(radioNo);
		bg.add(radioYes);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				log.writeLog("Cancelled the process.");
				log.destroy();
				window.dispose();
			}
		});
		btnNewButton.setFont(new Font("Alice", Font.BOLD, 16));
		btnNewButton.setBounds(579, 410, 95, 27);
		window.getContentPane().add(btnNewButton);

		JButton btnBack = new JButton("< Back");
		btnBack.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				log.writeLog("Clicked on Back Button Button");
				window.getContentPane().removeAll();
				window.repaint();
				new FirstPage(memory);
			}
		});
		btnBack.setFont(new Font("Alice", Font.BOLD, 16));
		btnBack.setBounds(369, 410, 95, 27);
		window.getContentPane().add(btnBack);
	}
}