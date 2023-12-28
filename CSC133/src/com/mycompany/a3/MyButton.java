package com.mycompany.a3;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.plaf.Border;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.plaf.Border;

//created my own custom class that extends button class
//I uss this class so all my buttons have the same styling
public class MyButton extends Button{
	public MyButton(){
		
		this.getAllStyles().setFgColor(ColorUtil.WHITE);
		this.getAllStyles().setBgColor(ColorUtil.rgb(0,0,255));
		this.getAllStyles().setBgTransparency(255);
		this.getAllStyles().setPaddingLeft(3);
		this.getAllStyles().setPaddingRight(3);
		this.getAllStyles().setPaddingTop(4);
		this.getAllStyles().setPaddingBottom(4);
		//this.getAllStyles().setPadding
		
		this.getAllStyles().setBorder(Border.createLineBorder(3,ColorUtil.BLACK)); 
	}
}