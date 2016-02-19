package com.example.tavosh.twolinegraph;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.opengl.GLSurfaceView;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.BarChart;
import org.achartengine.chart.LineChart;
import org.achartengine.model.TimeSeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

/**
 * Created by tavosh on 23/09/2015.
 */
public class LineGraph {

    public GraphicalView getView(Context context){
        int[] x = {1,2,3,4,5,6,7,8,9,10};
        int[] y = {30, 34, 45, 57, 77, 89, 100, 111, 123, 145};

        int[] x2 = {1,2,3,4,5,6,7,8,9,10};
        int[] y2 = {145, 123, 111, 100, 89, 77, 57, 45, 34, 30};

        TimeSeries series = new TimeSeries("Line1");
        for (int i = 0; i < x.length; i++){
            series.add(x[i],y[i]);
        }

        TimeSeries series2 = new TimeSeries("Line2");
        for (int i = 0; i < x2.length; i++){
            series2.add(x2[i],y2[i]);
        }
        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
        dataset.addSeries(series);
        dataset.addSeries(series2);


        XYSeriesRenderer renderer = new XYSeriesRenderer();
        renderer.setColor(Color.WHITE);
        XYSeriesRenderer renderer2 = new XYSeriesRenderer();
        renderer2.setColor(Color.YELLOW);

        XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();
        mRenderer.addSeriesRenderer(renderer);
        mRenderer.addSeriesRenderer(renderer2);
        mRenderer.setApplyBackgroundColor(true);
        mRenderer.setBackgroundColor(Color.BLACK);

        //return ChartFactory.getLineChartView(context, dataset, mRenderer);

        String[] types = new String[]{BarChart.TYPE, LineChart.TYPE};
        return ChartFactory.getCombinedXYChartView(context, dataset, mRenderer, types);
    }
}
