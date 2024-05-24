package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import model.Period;

public class PanelCalendar extends JPanel {

	private static final long serialVersionUID = 1L;
	private CalendarCell man;
	private CalendarCell tir;
	private CalendarCell ons;
	private CalendarCell tor;
	private CalendarCell fre;
	private CalendarCell lør;
	private CalendarCell søn;
	private CalendarCell cell_1;
	private CalendarCell cell_2;
	private CalendarCell cell_3;
	private CalendarCell cell_4;
	private CalendarCell cell_5;
	private CalendarCell cell_6;
	private CalendarCell cell_7;
	private CalendarCell cell_8;
	private CalendarCell cell_9;
	private CalendarCell cell_10;
	private CalendarCell cell_11;
	private CalendarCell cell_12;
	private CalendarCell cell_13;
	private CalendarCell cell_14;
	private CalendarCell cell_15;
	private CalendarCell cell_16;
	private CalendarCell cell_17;
	private CalendarCell cell_18;
	private CalendarCell cell_19;
	private CalendarCell cell_20;
	private CalendarCell cell_21;
	private CalendarCell cell_22;
	private CalendarCell cell_23;
	private CalendarCell cell_24;
	private CalendarCell cell_25;
	private CalendarCell cell_26;
	private CalendarCell cell_27;
	private CalendarCell cell_28;
	private CalendarCell cell_29;
	private CalendarCell cell_30;
	private CalendarCell cell_31;
	private CalendarCell cell_32;
	private CalendarCell cell_33;
	private CalendarCell cell_34;
	private CalendarCell cell_35;
	private CalendarCell cell_36;
	private CalendarCell cell_37;
	private CalendarCell cell_38;
	private CalendarCell cell_39;
	private CalendarCell cell_40;
	private CalendarCell cell_41;
	private CalendarCell cell_42;

	private LocalDate today;
	private LocalDate date;
	
	/**
	 * Create the panel.
	 */
	public PanelCalendar() {
		initComponents();
        init();
	}
	
	private void init() {
		man.setTitle(true);
		tir.setTitle(true);
		ons.setTitle(true);
		tor.setTitle(true);
		fre.setTitle(true);
		lør.setTitle(true);
		søn.setTitle(true);
		today = LocalDate.now();
        setDate(today.getMonthValue(), today.getYear());
	}
	
	private void updateCalendar() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, date.getYear());
		calendar.set(Calendar.MONTH, date.getMonthValue() - 1);
		calendar.set(Calendar.DATE, 1);
		int startDay = calendar.get(Calendar.DAY_OF_WEEK) - 2;
		calendar.add(Calendar.DATE, - startDay);
		for (Component component : getComponents()) {
			CalendarCell cell = (CalendarCell) component;
			if (!cell.isTitle()) {
				cell.setText(calendar.get(Calendar.DATE) + ".");
				cell.setDate(calendar.getTime());
				cell.inMonth(calendar.get(Calendar.MONTH) == date.getMonthValue() - 1);
				calendar.add(Calendar.DATE, 1);
			}
		}
	}
	
	public void setDate(int month, int year) {
		this.date = LocalDate.of(year, month, 1);
		updateCalendar();
	}
	
	public LocalDate getDate() {
		return date;
	}

	private void initComponents() {
		setLayout(new GridLayout(7, 7, 0, 0));

		man = new CalendarCell();
		man.setHorizontalAlignment(SwingConstants.LEFT);
		man.setBorder(new LineBorder(new Color(0, 0, 0)));
		man.setVerticalAlignment(SwingConstants.TOP);
        man.setText("Man");
        man.setFont(new Font("Arial", Font.BOLD, 14));
        add(man);
        
        tir = new CalendarCell();
        tir.setHorizontalAlignment(SwingConstants.LEFT);
        tir.setBorder(new LineBorder(new Color(0, 0, 0)));
        tir.setVerticalAlignment(SwingConstants.TOP);
        tir.setText("Tir");
        tir.setFont(new Font("Arial", Font.BOLD, 14));
        add(tir);
        
        ons = new CalendarCell();
        ons.setHorizontalAlignment(SwingConstants.LEFT);
        ons.setBorder(new LineBorder(new Color(0, 0, 0)));
        ons.setVerticalAlignment(SwingConstants.TOP);
        ons.setText("Ons");
        ons.setFont(new Font("Arial", Font.BOLD, 14));
        add(ons);
        
        tor = new CalendarCell();
        tor.setHorizontalAlignment(SwingConstants.LEFT);
        tor.setBorder(new LineBorder(new Color(0, 0, 0)));
        tor.setVerticalAlignment(SwingConstants.TOP);
        tor.setText("Tor");
        tor.setFont(new Font("Arial", Font.BOLD, 14));
        add(tor);
        
        fre = new CalendarCell();
        fre.setHorizontalAlignment(SwingConstants.LEFT);
        fre.setBorder(new LineBorder(new Color(0, 0, 0)));
        fre.setVerticalAlignment(SwingConstants.TOP);
        fre.setText("Fre");
        fre.setFont(new Font("Arial", Font.BOLD, 14));
        add(fre);
        
        lør = new CalendarCell();
        lør.setHorizontalAlignment(SwingConstants.LEFT);
        lør.setBorder(new LineBorder(new Color(0, 0, 0)));
        lør.setVerticalAlignment(SwingConstants.TOP);
        lør.setText("Lør");
        lør.setFont(new Font("Arial", Font.BOLD, 14));
        add(lør);
        
        søn = new CalendarCell();
        søn.setHorizontalAlignment(SwingConstants.LEFT);
        søn.setBorder(new LineBorder(new Color(0, 0, 0)));
        søn.setVerticalAlignment(SwingConstants.TOP);
        søn.setText("Søn");
        søn.setFont(new Font("Arial", Font.BOLD, 14));
        add(søn);
        
        cell_1 = new CalendarCell();
        cell_1.setHorizontalAlignment(SwingConstants.LEFT);
        cell_1.setBorder(new LineBorder(new Color(0, 0, 0)));
        cell_1.setVerticalAlignment(SwingConstants.TOP);
        cell_1.setFont(new Font("Arial", Font.BOLD, 14));
        add(cell_1);
        
        cell_2 = new CalendarCell();
        cell_2.setHorizontalAlignment(SwingConstants.LEFT);
        cell_2.setBorder(new LineBorder(new Color(0, 0, 0)));
        cell_2.setVerticalAlignment(SwingConstants.TOP);
        cell_2.setFont(new Font("Arial", Font.BOLD, 14));
        add(cell_2);
        
        cell_3 = new CalendarCell();
        cell_3.setHorizontalAlignment(SwingConstants.LEFT);
        cell_3.setBorder(new LineBorder(new Color(0, 0, 0)));
        cell_3.setVerticalAlignment(SwingConstants.TOP);
        cell_3.setFont(new Font("Arial", Font.BOLD, 14));
        add(cell_3);
        
        cell_4 = new CalendarCell();
        cell_4.setHorizontalAlignment(SwingConstants.LEFT);
        cell_4.setBorder(new LineBorder(new Color(0, 0, 0)));
        cell_4.setVerticalAlignment(SwingConstants.TOP);
        cell_4.setFont(new Font("Arial", Font.BOLD, 14));
        add(cell_4);
        
        cell_5 = new CalendarCell();
        cell_5.setHorizontalAlignment(SwingConstants.LEFT);
        cell_5.setBorder(new LineBorder(new Color(0, 0, 0)));
        cell_5.setVerticalAlignment(SwingConstants.TOP);
        cell_5.setFont(new Font("Arial", Font.BOLD, 14));
        add(cell_5);
        
        cell_6 = new CalendarCell();
        cell_6.setHorizontalAlignment(SwingConstants.LEFT);
        cell_6.setBorder(new LineBorder(new Color(0, 0, 0)));
        cell_6.setVerticalAlignment(SwingConstants.TOP);
        cell_6.setFont(new Font("Arial", Font.BOLD, 14));
        add(cell_6);
        
        cell_7 = new CalendarCell();
        cell_7.setHorizontalAlignment(SwingConstants.LEFT);
        cell_7.setBorder(new LineBorder(new Color(0, 0, 0)));
        cell_7.setVerticalAlignment(SwingConstants.TOP);
        cell_7.setFont(new Font("Arial", Font.BOLD, 14));
        add(cell_7);
        
        cell_8 = new CalendarCell();
        cell_8.setHorizontalAlignment(SwingConstants.LEFT);
        cell_8.setBorder(new LineBorder(new Color(0, 0, 0)));
        cell_8.setVerticalAlignment(SwingConstants.TOP);
        cell_8.setFont(new Font("Arial", Font.BOLD, 14));
        add(cell_8);
        
        cell_9 = new CalendarCell();
        cell_9.setHorizontalAlignment(SwingConstants.LEFT);
        cell_9.setBorder(new LineBorder(new Color(0, 0, 0)));
        cell_9.setVerticalAlignment(SwingConstants.TOP);
        cell_9.setFont(new Font("Arial", Font.BOLD, 14));
        add(cell_9);
        
        cell_10 = new CalendarCell();
        cell_10.setHorizontalAlignment(SwingConstants.LEFT);
        cell_10.setBorder(new LineBorder(new Color(0, 0, 0)));
        cell_10.setVerticalAlignment(SwingConstants.TOP);
        cell_10.setFont(new Font("Arial", Font.BOLD, 14));
        add(cell_10);
        
        cell_11 = new CalendarCell();
        cell_11.setHorizontalAlignment(SwingConstants.LEFT);
        cell_11.setBorder(new LineBorder(new Color(0, 0, 0)));
        cell_11.setVerticalAlignment(SwingConstants.TOP);
        cell_11.setFont(new Font("Arial", Font.BOLD, 14));
        add(cell_11);
        
        cell_12 = new CalendarCell();
        cell_12.setHorizontalAlignment(SwingConstants.LEFT);
        cell_12.setBorder(new LineBorder(new Color(0, 0, 0)));
        cell_12.setVerticalAlignment(SwingConstants.TOP);
        cell_12.setFont(new Font("Arial", Font.BOLD, 14));
        add(cell_12);
        
        cell_13 = new CalendarCell();
        cell_13.setHorizontalAlignment(SwingConstants.LEFT);
        cell_13.setBorder(new LineBorder(new Color(0, 0, 0)));
        cell_13.setVerticalAlignment(SwingConstants.TOP);
        cell_13.setFont(new Font("Arial", Font.BOLD, 14));
        add(cell_13);
        
        cell_14 = new CalendarCell();
        cell_14.setHorizontalAlignment(SwingConstants.LEFT);
        cell_14.setBorder(new LineBorder(new Color(0, 0, 0)));
        cell_14.setVerticalAlignment(SwingConstants.TOP);
        cell_14.setFont(new Font("Arial", Font.BOLD, 14));
        add(cell_14);
        
        cell_15 = new CalendarCell();
        cell_15.setHorizontalAlignment(SwingConstants.LEFT);
        cell_15.setBorder(new LineBorder(new Color(0, 0, 0)));
        cell_15.setVerticalAlignment(SwingConstants.TOP);
        cell_15.setFont(new Font("Arial", Font.BOLD, 14));
        add(cell_15);
        
        cell_16 = new CalendarCell();
        cell_16.setHorizontalAlignment(SwingConstants.LEFT);
        cell_16.setBorder(new LineBorder(new Color(0, 0, 0)));
        cell_16.setVerticalAlignment(SwingConstants.TOP);
        cell_16.setFont(new Font("Arial", Font.BOLD, 14));
        add(cell_16);
        
        cell_17 = new CalendarCell();
        cell_17.setHorizontalAlignment(SwingConstants.LEFT);
        cell_17.setBorder(new LineBorder(new Color(0, 0, 0)));
        cell_17.setVerticalAlignment(SwingConstants.TOP);
        cell_17.setFont(new Font("Arial", Font.BOLD, 14));
        add(cell_17);
        
        cell_18 = new CalendarCell();
        cell_18.setHorizontalAlignment(SwingConstants.LEFT);
        cell_18.setBorder(new LineBorder(new Color(0, 0, 0)));
        cell_18.setVerticalAlignment(SwingConstants.TOP);
        cell_18.setFont(new Font("Arial", Font.BOLD, 14));
        add(cell_18);
        
        cell_19 = new CalendarCell();
        cell_19.setHorizontalAlignment(SwingConstants.LEFT);
        cell_19.setBorder(new LineBorder(new Color(0, 0, 0)));
        cell_19.setVerticalAlignment(SwingConstants.TOP);
        cell_19.setFont(new Font("Arial", Font.BOLD, 14));
        add(cell_19);
        
        cell_20 = new CalendarCell();
        cell_20.setHorizontalAlignment(SwingConstants.LEFT);
        cell_20.setBorder(new LineBorder(new Color(0, 0, 0)));
        cell_20.setVerticalAlignment(SwingConstants.TOP);
        cell_20.setFont(new Font("Arial", Font.BOLD, 14));
        add(cell_20);
        
        cell_21 = new CalendarCell();
        cell_21.setHorizontalAlignment(SwingConstants.LEFT);
        cell_21.setBorder(new LineBorder(new Color(0, 0, 0)));
        cell_21.setVerticalAlignment(SwingConstants.TOP);
        cell_21.setFont(new Font("Arial", Font.BOLD, 14));
        add(cell_21);
        
        cell_22 = new CalendarCell();
        cell_22.setHorizontalAlignment(SwingConstants.LEFT);
        cell_22.setBorder(new LineBorder(new Color(0, 0, 0)));
        cell_22.setVerticalAlignment(SwingConstants.TOP);
        cell_22.setFont(new Font("Arial", Font.BOLD, 14));
        add(cell_22);
        
        cell_23 = new CalendarCell();
        cell_23.setHorizontalAlignment(SwingConstants.LEFT);
        cell_23.setBorder(new LineBorder(new Color(0, 0, 0)));
        cell_23.setVerticalAlignment(SwingConstants.TOP);
        cell_23.setFont(new Font("Arial", Font.BOLD, 14));
        add(cell_23);
        
        cell_24 = new CalendarCell();
        cell_24.setHorizontalAlignment(SwingConstants.LEFT);
        cell_24.setBorder(new LineBorder(new Color(0, 0, 0)));
        cell_24.setVerticalAlignment(SwingConstants.TOP);
        cell_24.setFont(new Font("Arial", Font.BOLD, 14));
        add(cell_24);
        
        cell_25 = new CalendarCell();
        cell_25.setHorizontalAlignment(SwingConstants.LEFT);
        cell_25.setBorder(new LineBorder(new Color(0, 0, 0)));
        cell_25.setVerticalAlignment(SwingConstants.TOP);
        cell_25.setFont(new Font("Arial", Font.BOLD, 14));
        add(cell_25);
        
        cell_26 = new CalendarCell();
        cell_26.setHorizontalAlignment(SwingConstants.LEFT);
        cell_26.setBorder(new LineBorder(new Color(0, 0, 0)));
        cell_26.setVerticalAlignment(SwingConstants.TOP);
        cell_26.setFont(new Font("Arial", Font.BOLD, 14));
        add(cell_26);
        
        cell_27 = new CalendarCell();
        cell_27.setHorizontalAlignment(SwingConstants.LEFT);
        cell_27.setBorder(new LineBorder(new Color(0, 0, 0)));
        cell_27.setVerticalAlignment(SwingConstants.TOP);
        cell_27.setFont(new Font("Arial", Font.BOLD, 14));
        add(cell_27);
        
        cell_28 = new CalendarCell();
        cell_28.setHorizontalAlignment(SwingConstants.LEFT);
        cell_28.setBorder(new LineBorder(new Color(0, 0, 0)));
        cell_28.setVerticalAlignment(SwingConstants.TOP);
        cell_28.setFont(new Font("Arial", Font.BOLD, 14));
        add(cell_28);
        
        cell_29 = new CalendarCell();
        cell_29.setHorizontalAlignment(SwingConstants.LEFT);
        cell_29.setBorder(new LineBorder(new Color(0, 0, 0)));
        cell_29.setVerticalAlignment(SwingConstants.TOP);
        cell_29.setFont(new Font("Arial", Font.BOLD, 14));
        add(cell_29);
        
        cell_30 = new CalendarCell();
        cell_30.setHorizontalAlignment(SwingConstants.LEFT);
        cell_30.setBorder(new LineBorder(new Color(0, 0, 0)));
        cell_30.setVerticalAlignment(SwingConstants.TOP);
        cell_30.setFont(new Font("Arial", Font.BOLD, 14));
        add(cell_30);
        
        cell_31 = new CalendarCell();
        cell_31.setHorizontalAlignment(SwingConstants.LEFT);
        cell_31.setBorder(new LineBorder(new Color(0, 0, 0)));
        cell_31.setVerticalAlignment(SwingConstants.TOP);
        cell_31.setFont(new Font("Arial", Font.BOLD, 14));
        add(cell_31);
        
        cell_32 = new CalendarCell();
        cell_32.setHorizontalAlignment(SwingConstants.LEFT);
        cell_32.setBorder(new LineBorder(new Color(0, 0, 0)));
        cell_32.setVerticalAlignment(SwingConstants.TOP);
        cell_32.setFont(new Font("Arial", Font.BOLD, 14));
        add(cell_32);
        
        cell_33 = new CalendarCell();
        cell_33.setHorizontalAlignment(SwingConstants.LEFT);
        cell_33.setBorder(new LineBorder(new Color(0, 0, 0)));
        cell_33.setVerticalAlignment(SwingConstants.TOP);
        cell_33.setFont(new Font("Arial", Font.BOLD, 14));
        add(cell_33);
        
        cell_34 = new CalendarCell();
        cell_34.setHorizontalAlignment(SwingConstants.LEFT);
        cell_34.setBorder(new LineBorder(new Color(0, 0, 0)));
        cell_34.setVerticalAlignment(SwingConstants.TOP);
        cell_34.setFont(new Font("Arial", Font.BOLD, 14));
        add(cell_34);
        
        cell_35 = new CalendarCell();
        cell_35.setHorizontalAlignment(SwingConstants.LEFT);
        cell_35.setBorder(new LineBorder(new Color(0, 0, 0)));
        cell_35.setVerticalAlignment(SwingConstants.TOP);
        cell_35.setFont(new Font("Arial", Font.BOLD, 14));
        add(cell_35);
        
        cell_36 = new CalendarCell();
        cell_36.setHorizontalAlignment(SwingConstants.LEFT);
        cell_36.setBorder(new LineBorder(new Color(0, 0, 0)));
        cell_36.setVerticalAlignment(SwingConstants.TOP);
        cell_36.setFont(new Font("Arial", Font.BOLD, 14));
        add(cell_36);
        
        cell_37 = new CalendarCell();
        cell_37.setHorizontalAlignment(SwingConstants.LEFT);
        cell_37.setBorder(new LineBorder(new Color(0, 0, 0)));
        cell_37.setVerticalAlignment(SwingConstants.TOP);
        cell_37.setFont(new Font("Arial", Font.BOLD, 14));
        add(cell_37);
        
        cell_38 = new CalendarCell();
        cell_38.setHorizontalAlignment(SwingConstants.LEFT);
        cell_38.setBorder(new LineBorder(new Color(0, 0, 0)));
        cell_38.setVerticalAlignment(SwingConstants.TOP);
        cell_38.setFont(new Font("Arial", Font.BOLD, 14));
        add(cell_38);
        
        cell_39 = new CalendarCell();
        cell_39.setHorizontalAlignment(SwingConstants.LEFT);
        cell_39.setBorder(new LineBorder(new Color(0, 0, 0)));
        cell_39.setVerticalAlignment(SwingConstants.TOP);
        cell_39.setFont(new Font("Arial", Font.BOLD, 14));
        add(cell_39);
        
        cell_40 = new CalendarCell();
        cell_40.setHorizontalAlignment(SwingConstants.LEFT);
        cell_40.setBorder(new LineBorder(new Color(0, 0, 0)));
        cell_40.setVerticalAlignment(SwingConstants.TOP);
        cell_40.setFont(new Font("Arial", Font.BOLD, 14));
        add(cell_40);
        
        cell_41 = new CalendarCell();
        cell_41.setHorizontalAlignment(SwingConstants.LEFT);
        cell_41.setBorder(new LineBorder(new Color(0, 0, 0)));
        cell_41.setVerticalAlignment(SwingConstants.TOP);
        cell_41.setFont(new Font("Arial", Font.BOLD, 14));
        add(cell_41);
        
        cell_42 = new CalendarCell();
        cell_42.setHorizontalAlignment(SwingConstants.LEFT);
        cell_42.setBorder(new LineBorder(new Color(0, 0, 0)));
        cell_42.setVerticalAlignment(SwingConstants.TOP);
        cell_42.setFont(new Font("Arial", Font.BOLD, 14));
        add(cell_42);
        
	}
}
