package app;

/**
 * Created by Raul on 5/4/2017.
 */
public class FactoryClass {

  public Report generateReport(String input){
      if(input.equals("pdf")) return new ReportPdf();
      else if (input.equals("csv")) return new ReportCsv();
     else return new ReportCsv();
  }
}
