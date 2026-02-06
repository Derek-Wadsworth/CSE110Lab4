package edu.ucsd.spendingtracker.view.charts;
import edu.ucsd.spendingtracker.model.Category;
import java.util.Map;
import javafx.scene.Node;


import javafx.scene.chart.PieChart;

public class PieChartProvider implements IChartProvider {
    @Override
    public Node createChart(Map<Category, Double> data) {
        PieChart chart = new PieChart();

        data.forEach((cat, sum) -> {
            chart.getData().add(new PieChart.Data(cat.name(), sum));
        });

        for (PieChart.Data entry: chart.getData()) {
            String color = Category.valueOf(entry.getName()).color;
            Node slice = entry.getNode();
            if (slice != null) {
                slice.setStyle("-fx-pie-color: " + color + ";");
            }
        }   


        chart.setLegendVisible(false);
        return chart;
    }

    @Override
    public String getDisplayName() {
        return "Pie Chart";
    }
    
}
