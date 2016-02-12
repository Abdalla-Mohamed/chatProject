package framepackage;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Eng-AYA
 */
public class MyPieChart {

    public MyPieChart() {

        DefaultPieDataset pieDataset = new DefaultPieDataset();
        pieDataset.setValue("Online", new Integer(10));
        pieDataset.setValue("Offline", new Integer(20));
        pieDataset.setValue("Busy", new Integer(30));
        pieDataset.setValue("Away", new Integer(40));
        JFreeChart chart = ChartFactory
                .createPieChart("my pie", pieDataset, true, true, true);

        PiePlot P = (PiePlot) chart.getPlot();
//P.setForegroundAlpha(TOP_ALIGNMENT);
        ChartFrame f = new ChartFrame("chart", chart);
        f.setVisible(true);
        f.setSize(500, 700);
    }

}
