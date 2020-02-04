/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uangkuapplication.service;

/**
 *
 * @author Wildhevire
 */
import org.knowm.xchart.internal.chartpart.Chart;
public interface IXChart <C,D extends Chart<?, ?>> {
    


  C getPemasukanChart();
  C getPengeluaranChart();
  D getTotalChart();
}
