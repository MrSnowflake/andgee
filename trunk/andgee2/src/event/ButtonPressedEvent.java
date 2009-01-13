/*
 * wiigee - accelerometerbased gesture recognition
 * Copyright (C) 2007, 2008 Benjamin Poppinga
 * 
 * Developed at University of Oldenburg
 * Contact: benjamin.poppinga@informatik.uni-oldenburg.de
 *
 * This file is part of wiigee.
 *
 * wiigee is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package event;

import device.*;

/**
 * 
 * This Event would be generated if a button on a wiimote has been
 * pressed by user. It contains the source (wiimote) and an integer
 * representation of which button has been pressed. Please note that
 * there exist enumeration constants in the class, so you don't
 * have to use this integer values directly.
 * 
 * Button 1 matches button "2" on wiimote
 * Button 2 matches button "1" on wiimote
 * Button 3 matches button "B" on wiimote
 * Button 4 matches button "A" on wiimote
 * Button 5 matches button "MINUS" on wiimote
 * Button 6 unknown
 * Button 7 unknown
 * Button 8 matches button "HOME" on wiimote
 * Button 9 matches "CROSS LEFT" on wiimote
 * Button 10 matches "CROSS RIGHT" on wiimote
 * Button 11 matches "CROSS DOWN" on wiimote
 * Button 12 matches "CROSS UP" on wiimote
 * Button 13 matches button "PLUS" on wiimote
 * Button 14 unknown
 * Button 15 unknown
 * Button 16 unknown
 *
 * @author Benjamin 'BePo' Poppinga
 */
public class ButtonPressedEvent extends ActionStartEvent {
	
	// Fixed number values.
	public static final int BUTTON_2 = 1;
	public static final int BUTTON_1 = 2;
	public static final int BUTTON_B = 3;
	public static final int BUTTON_A = 4;
	public static final int BUTTON_MINUS = 5;
	public static final int BUTTON_HOME = 8;
	public static final int BUTTON_LEFT = 9;
	public static final int BUTTON_RIGHT = 10;
	public static final int BUTTON_DOWN = 11;
	public static final int BUTTON_UP = 12;
	public static final int BUTTON_PLUS = 13;
	
	int button;

	/**
	 * Create a WiimoteButtonPressedEvent with the Wiimote source whose
	 * Button has been pressed and the integer representation of the button.
	 * 
	 * @param source
	 * @param button
	 */
	public ButtonPressedEvent(Device source, int button) {
		super(source);
		this.button=button;
		
		if(source.getRecognitionButton()==button) {
			this.recognitionbutton=true;
		} else if(source.getTrainButton()==button) {
			this.trainbutton=true;
		} else if(source.getCloseGestureButton()==button) {
			this.closegesturebutton=true;
		}
	}
	
	public int getButton() {
		return this.button;
	}
	
}
