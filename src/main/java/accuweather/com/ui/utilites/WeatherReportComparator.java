package accuweather.com.ui.utilites;

import accuweather.com.api.pojos.Response.WeatherResponse.Sys;

import java.math.BigDecimal;

public class WeatherReportComparator {

    public int compare(BigDecimal uiTemp, BigDecimal mwTemp)
    {
        mwTemp = mwTemp.subtract(BigDecimal.valueOf(273));
        BigDecimal result = uiTemp.subtract(mwTemp);
        return result.compareTo(BigDecimal.valueOf(2));
    }

}
