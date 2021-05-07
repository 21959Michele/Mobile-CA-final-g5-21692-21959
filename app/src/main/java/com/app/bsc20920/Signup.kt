// Michele Sousa & Mubasher Zeb Khan

// 21959 & 21694


package com.app.bsc20920

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.app.bsc20920.R
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject


class Signup : AppCompatActivity() {

    var jsonStr =
        "[{\"number\":42,\"contract_name\":\"dublin\",\"name\":\"SMITHFIELD NORTH\",\"address\":\"Smithfield North\",\"position\":{\"lat\":53.349562,\"lng\":-6.278198},\"banking\":false,\"bonus\":false,\"bike_stands\":30,\"available_bike_stands\":1,\"available_bikes\":29,\"status\":\"OPEN\",\"last_update\":1618514815000},{\"number\":30,\"contract_name\":\"dublin\",\"name\":\"PARNELL SQUARE NORTH\",\"address\":\"Parnell Square North\",\"position\":{\"lat\":53.353462,\"lng\":-6.265305},\"banking\":false,\"bonus\":false,\"bike_stands\":20,\"available_bike_stands\":15,\"available_bikes\":5,\"status\":\"OPEN\",\"last_update\":1618514832000},{\"number\":54,\"contract_name\":\"dublin\",\"name\":\"CLONMEL STREET\",\"address\":\"Clonmel Street\",\"position\":{\"lat\":53.336021,\"lng\":-6.26298},\"banking\":false,\"bonus\":false,\"bike_stands\":33,\"available_bike_stands\":21,\"available_bikes\":12,\"status\":\"OPEN\",\"last_update\":1618514564000},{\"number\":108,\"contract_name\":\"dublin\",\"name\":\"AVONDALE ROAD\",\"address\":\"Avondale Road\",\"position\":{\"lat\":53.359405,\"lng\":-6.276142},\"banking\":false,\"bonus\":false,\"bike_stands\":40,\"available_bike_stands\":20,\"available_bikes\":20,\"status\":\"OPEN\",\"last_update\":1618514746000},{\"number\":56,\"contract_name\":\"dublin\",\"name\":\"MOUNT STREET LOWER\",\"address\":\"Mount Street Lower\",\"position\":{\"lat\":53.33796,\"lng\":-6.24153},\"banking\":false,\"bonus\":false,\"bike_stands\":40,\"available_bike_stands\":29,\"available_bikes\":11,\"status\":\"OPEN\",\"last_update\":1618514477000},{\"number\":6,\"contract_name\":\"dublin\",\"name\":\"CHRISTCHURCH PLACE\",\"address\":\"Christchurch Place\",\"position\":{\"lat\":53.343368,\"lng\":-6.27012},\"banking\":false,\"bonus\":false,\"bike_stands\":20,\"available_bike_stands\":18,\"available_bikes\":2,\"status\":\"OPEN\",\"last_update\":1618514895000},{\"number\":18,\"contract_name\":\"dublin\",\"name\":\"GRANTHAM STREET\",\"address\":\"Grantham Street\",\"position\":{\"lat\":53.334123,\"lng\":-6.265436},\"banking\":false,\"bonus\":false,\"bike_stands\":30,\"available_bike_stands\":5,\"available_bikes\":25,\"status\":\"OPEN\",\"last_update\":1618514573000},{\"number\":32,\"contract_name\":\"dublin\",\"name\":\"PEARSE STREET\",\"address\":\"Pearse Street\",\"position\":{\"lat\":53.344304,\"lng\":-6.250427},\"banking\":false,\"bonus\":false,\"bike_stands\":30,\"available_bike_stands\":13,\"available_bikes\":17,\"status\":\"OPEN\",\"last_update\":1618514821000},{\"number\":52,\"contract_name\":\"dublin\",\"name\":\"YORK STREET EAST\",\"address\":\"York Street East\",\"position\":{\"lat\":53.338755,\"lng\":-6.262003},\"banking\":false,\"bonus\":false,\"bike_stands\":32,\"available_bike_stands\":20,\"available_bikes\":12,\"status\":\"OPEN\",\"last_update\":1618514682000},{\"number\":48,\"contract_name\":\"dublin\",\"name\":\"EXCISE WALK\",\"address\":\"Excise Walk\",\"position\":{\"lat\":53.347777,\"lng\":-6.244239},\"banking\":false,\"bonus\":false,\"bike_stands\":40,\"available_bike_stands\":25,\"available_bikes\":15,\"status\":\"OPEN\",\"last_update\":1618514922000},{\"number\":13,\"contract_name\":\"dublin\",\"name\":\"FITZWILLIAM SQUARE WEST\",\"address\":\"Fitzwilliam Square West\",\"position\":{\"lat\":53.336074,\"lng\":-6.252825},\"banking\":false,\"bonus\":false,\"bike_stands\":30,\"available_bike_stands\":26,\"available_bikes\":4,\"status\":\"OPEN\",\"last_update\":1618514578000},{\"number\":43,\"contract_name\":\"dublin\",\"name\":\"PORTOBELLO ROAD\",\"address\":\"Portobello Road\",\"position\":{\"lat\":53.330091,\"lng\":-6.268044},\"banking\":false,\"bonus\":false,\"bike_stands\":30,\"available_bike_stands\":26,\"available_bikes\":4,\"status\":\"OPEN\",\"last_update\":1618515024000},{\"number\":31,\"contract_name\":\"dublin\",\"name\":\"PARNELL STREET\",\"address\":\"Parnell Street\",\"position\":{\"lat\":53.350929,\"lng\":-6.265125},\"banking\":false,\"bonus\":false,\"bike_stands\":20,\"available_bike_stands\":3,\"available_bikes\":17,\"status\":\"OPEN\",\"last_update\":1618514995000},{\"number\":98,\"contract_name\":\"dublin\",\"name\":\"FREDERICK STREET SOUTH\",\"address\":\"Frederick Street South\",\"position\":{\"lat\":53.341515,\"lng\":-6.256853},\"banking\":false,\"bonus\":false,\"bike_stands\":40,\"available_bike_stands\":33,\"available_bikes\":7,\"status\":\"OPEN\",\"last_update\":1618514921000},{\"number\":23,\"contract_name\":\"dublin\",\"name\":\"CUSTOM HOUSE\",\"address\":\"Custom House\",\"position\":{\"lat\":53.348279,\"lng\":-6.254662},\"banking\":false,\"bonus\":false,\"bike_stands\":30,\"available_bike_stands\":13,\"available_bikes\":17,\"status\":\"OPEN\",\"last_update\":1618515051000},{\"number\":106,\"contract_name\":\"dublin\",\"name\":\"RATHDOWN ROAD\",\"address\":\"Rathdown Road\",\"position\":{\"lat\":53.35893,\"lng\":-6.280337},\"banking\":false,\"bonus\":false,\"bike_stands\":40,\"available_bike_stands\":16,\"available_bikes\":24,\"status\":\"OPEN\",\"last_update\":1618514604000},{\"number\":112,\"contract_name\":\"dublin\",\"name\":\"NORTH CIRCULAR ROAD (O'CONNELL'S)\",\"address\":\"North Circular Road (O'Connell's)\",\"position\":{\"lat\":53.357841,\"lng\":-6.251557},\"banking\":false,\"bonus\":false,\"bike_stands\":30,\"available_bike_stands\":17,\"available_bikes\":13,\"status\":\"OPEN\",\"last_update\":1618514930000},{\"number\":68,\"contract_name\":\"dublin\",\"name\":\"HANOVER QUAY\",\"address\":\"Hanover Quay\",\"position\":{\"lat\":53.344115,\"lng\":-6.237153},\"banking\":false,\"bonus\":false,\"bike_stands\":40,\"available_bike_stands\":16,\"available_bikes\":24,\"status\":\"OPEN\",\"last_update\":1618514895000},{\"number\":74,\"contract_name\":\"dublin\",\"name\":\"OLIVER BOND STREET\",\"address\":\"Oliver Bond Street\",\"position\":{\"lat\":53.343893,\"lng\":-6.280531},\"banking\":false,\"bonus\":false,\"bike_stands\":30,\"available_bike_stands\":26,\"available_bikes\":4,\"status\":\"OPEN\",\"last_update\":1618514986000},{\"number\":87,\"contract_name\":\"dublin\",\"name\":\"COLLINS BARRACKS MUSEUM\",\"address\":\"Collins Barracks Museum\",\"position\":{\"lat\":53.347477,\"lng\":-6.28525},\"banking\":false,\"bonus\":false,\"bike_stands\":38,\"available_bike_stands\":31,\"available_bikes\":7,\"status\":\"OPEN\",\"last_update\":1618514493000},{\"number\":84,\"contract_name\":\"dublin\",\"name\":\"BROOKFIELD ROAD\",\"address\":\"Brookfield Road\",\"position\":{\"lat\":53.339005,\"lng\":-6.300217},\"banking\":false,\"bonus\":false,\"bike_stands\":30,\"available_bike_stands\":12,\"available_bikes\":18,\"status\":\"OPEN\",\"last_update\":1618514793000},{\"number\":90,\"contract_name\":\"dublin\",\"name\":\"BENSON STREET\",\"address\":\"Benson Street\",\"position\":{\"lat\":53.344153,\"lng\":-6.233451},\"banking\":false,\"bonus\":false,\"bike_stands\":40,\"available_bike_stands\":20,\"available_bikes\":20,\"status\":\"OPEN\",\"last_update\":1618514986000},{\"number\":11,\"contract_name\":\"dublin\",\"name\":\"EARLSFORT TERRACE\",\"address\":\"Earlsfort Terrace\",\"position\":{\"lat\":53.334295,\"lng\":-6.258503},\"banking\":false,\"bonus\":false,\"bike_stands\":30,\"available_bike_stands\":25,\"available_bikes\":5,\"status\":\"OPEN\",\"last_update\":1618514979000},{\"number\":17,\"contract_name\":\"dublin\",\"name\":\"GOLDEN LANE\",\"address\":\"Golden Lane\",\"position\":{\"lat\":53.340803,\"lng\":-6.267732},\"banking\":false,\"bonus\":false,\"bike_stands\":20,\"available_bike_stands\":14,\"available_bikes\":6,\"status\":\"OPEN\",\"last_update\":1618514807000},{\"number\":45,\"contract_name\":\"dublin\",\"name\":\"DEVERELL PLACE\",\"address\":\"Deverell Place\",\"position\":{\"lat\":53.351464,\"lng\":-6.255265},\"banking\":false,\"bonus\":false,\"bike_stands\":30,\"available_bike_stands\":19,\"available_bikes\":11,\"status\":\"OPEN\",\"last_update\":1618514813000},{\"number\":114,\"contract_name\":\"dublin\",\"name\":\"WILTON TERRACE (PARK)\",\"address\":\"Wilton Terrace (Park)\",\"position\":{\"lat\":53.333653,\"lng\":-6.248345},\"banking\":false,\"bonus\":false,\"bike_stands\":40,\"available_bike_stands\":24,\"available_bikes\":16,\"status\":\"OPEN\",\"last_update\":1618514803000},{\"number\":72,\"contract_name\":\"dublin\",\"name\":\"JOHN STREET WEST\",\"address\":\"John Street West\",\"position\":{\"lat\":53.343105,\"lng\":-6.277167},\"banking\":false,\"bonus\":false,\"bike_stands\":31,\"available_bike_stands\":18,\"available_bikes\":13,\"status\":\"OPEN\",\"last_update\":1618514564000},{\"number\":63,\"contract_name\":\"dublin\",\"name\":\"FENIAN STREET\",\"address\":\"Fenian Street\",\"position\":{\"lat\":53.341428,\"lng\":-6.24672},\"banking\":false,\"bonus\":false,\"bike_stands\":35,\"available_bike_stands\":21,\"available_bikes\":14,\"status\":\"OPEN\",\"last_update\":1618514670000},{\"number\":113,\"contract_name\":\"dublin\",\"name\":\"MERRION SQUARE SOUTH\",\"address\":\"Merrion Square South\",\"position\":{\"lat\":53.338614,\"lng\":-6.248606},\"banking\":false,\"bonus\":false,\"bike_stands\":40,\"available_bike_stands\":29,\"available_bikes\":11,\"status\":\"OPEN\",\"last_update\":1618514749000},{\"number\":91,\"contract_name\":\"dublin\",\"name\":\"SOUTH DOCK ROAD\",\"address\":\"South Dock Road\",\"position\":{\"lat\":53.341833,\"lng\":-6.231291},\"banking\":false,\"bonus\":false,\"bike_stands\":30,\"available_bike_stands\":12,\"available_bikes\":17,\"status\":\"OPEN\",\"last_update\":1618515026000},{\"number\":99,\"contract_name\":\"dublin\",\"name\":\"CITY QUAY\",\"address\":\"City Quay\",\"position\":{\"lat\":53.346637,\"lng\":-6.246154},\"banking\":false,\"bonus\":false,\"bike_stands\":30,\"available_bike_stands\":24,\"available_bikes\":6,\"status\":\"OPEN\",\"last_update\":1618514501000},{\"number\":9,\"contract_name\":\"dublin\",\"name\":\"EXCHEQUER STREET\",\"address\":\"Exchequer Street\",\"position\":{\"lat\":53.343034,\"lng\":-6.263578},\"banking\":false,\"bonus\":false,\"bike_stands\":24,\"available_bike_stands\":24,\"available_bikes\":0,\"status\":\"OPEN\",\"last_update\":1618514662000},{\"number\":67,\"contract_name\":\"dublin\",\"name\":\"THE POINT\",\"address\":\"The Point\",\"position\":{\"lat\":53.346867,\"lng\":-6.230852},\"banking\":false,\"bonus\":false,\"bike_stands\":40,\"available_bike_stands\":15,\"available_bikes\":25,\"status\":\"OPEN\",\"last_update\":1618514998000},{\"number\":116,\"contract_name\":\"dublin\",\"name\":\"BROADSTONE\",\"address\":\"Broadstone\",\"position\":{\"lat\":53.3547,\"lng\":-6.272314},\"banking\":false,\"bonus\":false,\"bike_stands\":30,\"available_bike_stands\":25,\"available_bikes\":5,\"status\":\"OPEN\",\"last_update\":1618514857000},{\"number\":55,\"contract_name\":\"dublin\",\"name\":\"HATCH STREET\",\"address\":\"Hatch Street\",\"position\":{\"lat\":53.33403,\"lng\":-6.260714},\"banking\":false,\"bonus\":false,\"bike_stands\":36,\"available_bike_stands\":26,\"available_bikes\":10,\"status\":\"OPEN\",\"last_update\":1618514619000},{\"number\":62,\"contract_name\":\"dublin\",\"name\":\"LIME STREET\",\"address\":\"Lime Street\",\"position\":{\"lat\":53.346026,\"lng\":-6.243576},\"banking\":false,\"bonus\":false,\"bike_stands\":40,\"available_bike_stands\":27,\"available_bikes\":13,\"status\":\"OPEN\",\"last_update\":1618514543000},{\"number\":5,\"contract_name\":\"dublin\",\"name\":\"CHARLEMONT PLACE\",\"address\":\"Charlemont Street\",\"position\":{\"lat\":53.330662,\"lng\":-6.260177},\"banking\":false,\"bonus\":false,\"bike_stands\":40,\"available_bike_stands\":27,\"available_bikes\":13,\"status\":\"OPEN\",\"last_update\":1618514813000},{\"number\":97,\"contract_name\":\"dublin\",\"name\":\"KILMAINHAM GAOL\",\"address\":\"Kilmainham Gaol\",\"position\":{\"lat\":53.342113,\"lng\":-6.310015},\"banking\":false,\"bonus\":false,\"bike_stands\":40,\"available_bike_stands\":13,\"available_bikes\":27,\"status\":\"OPEN\",\"last_update\":1618515033000},{\"number\":61,\"contract_name\":\"dublin\",\"name\":\"HARDWICKE PLACE\",\"address\":\"Hardwicke Place\",\"position\":{\"lat\":53.357043,\"lng\":-6.263232},\"banking\":false,\"bonus\":false,\"bike_stands\":25,\"available_bike_stands\":11,\"available_bikes\":14,\"status\":\"OPEN\",\"last_update\":1618515031000},{\"number\":77,\"contract_name\":\"dublin\",\"name\":\"WOLFE TONE STREET\",\"address\":\"Wolfe Tone Street\",\"position\":{\"lat\":53.348875,\"lng\":-6.267459},\"banking\":false,\"bonus\":false,\"bike_stands\":29,\"available_bike_stands\":29,\"available_bikes\":0,\"status\":\"OPEN\",\"last_update\":1618514499000},{\"number\":73,\"contract_name\":\"dublin\",\"name\":\"FRANCIS STREET\",\"address\":\"Francis Street\",\"position\":{\"lat\":53.342081,\"lng\":-6.275233},\"banking\":false,\"bonus\":false,\"bike_stands\":30,\"available_bike_stands\":16,\"available_bikes\":14,\"status\":\"OPEN\",\"last_update\":1618514833000},{\"number\":4,\"contract_name\":\"dublin\",\"name\":\"GREEK STREET\",\"address\":\"Greek Street\",\"position\":{\"lat\":53.346874,\"lng\":-6.272976},\"banking\":false,\"bonus\":false,\"bike_stands\":20,\"available_bike_stands\":9,\"available_bikes\":11,\"status\":\"OPEN\",\"last_update\":1618515061000},{\"number\":49,\"contract_name\":\"dublin\",\"name\":\"GUILD STREET\",\"address\":\"Guild Street\",\"position\":{\"lat\":53.347932,\"lng\":-6.240928},\"banking\":false,\"bonus\":false,\"bike_stands\":40,\"available_bike_stands\":30,\"available_bikes\":10,\"status\":\"OPEN\",\"last_update\":1618514596000},{\"number\":19,\"contract_name\":\"dublin\",\"name\":\"HERBERT PLACE\",\"address\":\"Herbert Place\",\"position\":{\"lat\":53.334432,\"lng\":-6.245575},\"banking\":false,\"bonus\":false,\"bike_stands\":30,\"available_bike_stands\":24,\"available_bikes\":6,\"status\":\"OPEN\",\"last_update\":1618514888000},{\"number\":7,\"contract_name\":\"dublin\",\"name\":\"HIGH STREET\",\"address\":\"High Street\",\"position\":{\"lat\":53.343565,\"lng\":-6.275071},\"banking\":false,\"bonus\":false,\"bike_stands\":29,\"available_bike_stands\":21,\"available_bikes\":8,\"status\":\"OPEN\",\"last_update\":1618514891000},{\"number\":102,\"contract_name\":\"dublin\",\"name\":\"WESTERN WAY\",\"address\":\"Western Way\",\"position\":{\"lat\":53.354929,\"lng\":-6.269425},\"banking\":false,\"bonus\":false,\"bike_stands\":40,\"available_bike_stands\":30,\"available_bikes\":10,\"status\":\"OPEN\",\"last_update\":1618514966000},{\"number\":38,\"contract_name\":\"dublin\",\"name\":\"TALBOT STREET\",\"address\":\"Talbot Street\",\"position\":{\"lat\":53.350974,\"lng\":-6.25294},\"banking\":false,\"bonus\":false,\"bike_stands\":40,\"available_bike_stands\":13,\"available_bikes\":27,\"status\":\"OPEN\",\"last_update\":1618514661000},{\"number\":53,\"contract_name\":\"dublin\",\"name\":\"NEWMAN HOUSE\",\"address\":\"Newman House\",\"position\":{\"lat\":53.337132,\"lng\":-6.26059},\"banking\":false,\"bonus\":false,\"bike_stands\":40,\"available_bike_stands\":31,\"available_bikes\":9,\"status\":\"OPEN\",\"last_update\":1618515042000},{\"number\":58,\"contract_name\":\"dublin\",\"name\":\"SIR PATRICK DUN'S\",\"address\":\"Sir Patrick's Dun\",\"position\":{\"lat\":53.339218,\"lng\":-6.240642},\"banking\":false,\"bonus\":false,\"bike_stands\":40,\"available_bike_stands\":35,\"available_bikes\":5,\"status\":\"OPEN\",\"last_update\":1618514936000},{\"number\":66,\"contract_name\":\"dublin\",\"name\":\"NEW CENTRAL BANK\",\"address\":\"New Central Bank\",\"position\":{\"lat\":53.347122,\"lng\":-6.234749},\"banking\":false,\"bonus\":false,\"bike_stands\":40,\"available_bike_stands\":26,\"available_bikes\":14,\"status\":\"OPEN\",\"last_update\":1618514909000},{\"number\":104,\"contract_name\":\"dublin\",\"name\":\"GRANGEGORMAN LOWER (CENTRAL)\",\"address\":\"Grangegorman Lower (Central)\",\"position\":{\"lat\":53.355173,\"lng\":-6.278424},\"banking\":false,\"bonus\":false,\"bike_stands\":40,\"available_bike_stands\":30,\"available_bikes\":10,\"status\":\"OPEN\",\"last_update\":1618514957000},{\"number\":101,\"contract_name\":\"dublin\",\"name\":\"KING STREET NORTH\",\"address\":\"King Street North\",\"position\":{\"lat\":53.350291,\"lng\":-6.273507},\"banking\":false,\"bonus\":false,\"bike_stands\":30,\"available_bike_stands\":16,\"available_bikes\":14,\"status\":\"OPEN\",\"last_update\":1618514734000},{\"number\":115,\"contract_name\":\"dublin\",\"name\":\"KILLARNEY STREET\",\"address\":\"Killarney Street\",\"position\":{\"lat\":53.354845,\"lng\":-6.247579},\"banking\":false,\"bonus\":false,\"bike_stands\":30,\"available_bike_stands\":5,\"available_bikes\":25,\"status\":\"OPEN\",\"last_update\":1618515055000},{\"number\":47,\"contract_name\":\"dublin\",\"name\":\"HERBERT STREET\",\"address\":\"Herbert Street\",\"position\":{\"lat\":53.335742,\"lng\":-6.24551},\"banking\":false,\"bonus\":false,\"bike_stands\":40,\"available_bike_stands\":34,\"available_bikes\":6,\"status\":\"OPEN\",\"last_update\":1618514633000},{\"number\":117,\"contract_name\":\"dublin\",\"name\":\"HANOVER QUAY EAST\",\"address\":\"Hanover Quay East\",\"position\":{\"lat\":53.343653,\"lng\":-6.231755},\"banking\":false,\"bonus\":false,\"bike_stands\":40,\"available_bike_stands\":38,\"available_bikes\":2,\"status\":\"OPEN\",\"last_update\":1618514717000},{\"number\":8,\"contract_name\":\"dublin\",\"name\":\"CUSTOM HOUSE QUAY\",\"address\":\"Custom House Quay\",\"position\":{\"lat\":53.347884,\"lng\":-6.248048},\"banking\":false,\"bonus\":false,\"bike_stands\":30,\"available_bike_stands\":21,\"available_bikes\":9,\"status\":\"OPEN\",\"last_update\":1618515052000},{\"number\":27,\"contract_name\":\"dublin\",\"name\":\"MOLESWORTH STREET\",\"address\":\"Molesworth Street\",\"position\":{\"lat\":53.341288,\"lng\":-6.258117},\"banking\":false,\"bonus\":false,\"bike_stands\":20,\"available_bike_stands\":14,\"available_bikes\":6,\"status\":\"OPEN\",\"last_update\":1618514741000},{\"number\":16,\"contract_name\":\"dublin\",\"name\":\"GEORGES QUAY\",\"address\":\"Georges Quay\",\"position\":{\"lat\":53.347508,\"lng\":-6.252192},\"banking\":false,\"bonus\":false,\"bike_stands\":20,\"available_bike_stands\":16,\"available_bikes\":4,\"status\":\"OPEN\",\"last_update\":1618514962000},{\"number\":96,\"contract_name\":\"dublin\",\"name\":\"KILMAINHAM LANE\",\"address\":\"Kilmainham Lane\",\"position\":{\"lat\":53.341805,\"lng\":-6.305085},\"banking\":false,\"bonus\":false,\"bike_stands\":30,\"available_bike_stands\":13,\"available_bikes\":17,\"status\":\"OPEN\",\"last_update\":1618515020000},{\"number\":82,\"contract_name\":\"dublin\",\"name\":\"MOUNT BROWN\",\"address\":\"Mount Brown\",\"position\":{\"lat\":53.341645,\"lng\":-6.29719},\"banking\":false,\"bonus\":false,\"bike_stands\":22,\"available_bike_stands\":11,\"available_bikes\":11,\"status\":\"OPEN\",\"last_update\":1618514459000},{\"number\":76,\"contract_name\":\"dublin\",\"name\":\"MARKET STREET SOUTH\",\"address\":\"Market Street South\",\"position\":{\"lat\":53.342296,\"lng\":-6.287661},\"banking\":false,\"bonus\":false,\"bike_stands\":38,\"available_bike_stands\":25,\"available_bikes\":13,\"status\":\"OPEN\",\"last_update\":1618514614000},{\"number\":71,\"contract_name\":\"dublin\",\"name\":\"KEVIN STREET\",\"address\":\"Kevin Street\",\"position\":{\"lat\":53.337757,\"lng\":-6.267699},\"banking\":false,\"bonus\":false,\"bike_stands\":40,\"available_bike_stands\":29,\"available_bikes\":11,\"status\":\"OPEN\",\"last_update\":1618514774000},{\"number\":79,\"contract_name\":\"dublin\",\"name\":\"ECCLES STREET EAST\",\"address\":\"Eccles Street East\",\"position\":{\"lat\":53.358115,\"lng\":-6.265601},\"banking\":false,\"bonus\":false,\"bike_stands\":27,\"available_bike_stands\":21,\"available_bikes\":5,\"status\":\"OPEN\",\"last_update\":1618514933000},{\"number\":69,\"contract_name\":\"dublin\",\"name\":\"GRAND CANAL DOCK\",\"address\":\"Grand Canal Dock\",\"position\":{\"lat\":53.342638,\"lng\":-6.238695},\"banking\":false,\"bonus\":false,\"bike_stands\":40,\"available_bike_stands\":30,\"available_bikes\":10,\"status\":\"OPEN\",\"last_update\":1618514863000},{\"number\":25,\"contract_name\":\"dublin\",\"name\":\"MERRION SQUARE EAST\",\"address\":\"Merrion Square East\",\"position\":{\"lat\":53.339434,\"lng\":-6.246548},\"banking\":false,\"bonus\":false,\"bike_stands\":30,\"available_bike_stands\":22,\"available_bikes\":8,\"status\":\"OPEN\",\"last_update\":1618515047000},{\"number\":51,\"contract_name\":\"dublin\",\"name\":\"YORK STREET WEST\",\"address\":\"York Street West\",\"position\":{\"lat\":53.339334,\"lng\":-6.264699},\"banking\":false,\"bonus\":false,\"bike_stands\":40,\"available_bike_stands\":31,\"available_bikes\":8,\"status\":\"OPEN\",\"last_update\":1618514611000},{\"number\":37,\"contract_name\":\"dublin\",\"name\":\"ST. STEPHEN'S GREEN SOUTH\",\"address\":\"St. Stephen's Green South\",\"position\":{\"lat\":53.337494,\"lng\":-6.26199},\"banking\":false,\"bonus\":false,\"bike_stands\":30,\"available_bike_stands\":11,\"available_bikes\":19,\"status\":\"OPEN\",\"last_update\":1618514672000},{\"number\":59,\"contract_name\":\"dublin\",\"name\":\"DENMARK STREET GREAT\",\"address\":\"Denmark Street Great\",\"position\":{\"lat\":53.35561,\"lng\":-6.261397},\"banking\":false,\"bonus\":false,\"bike_stands\":20,\"available_bike_stands\":10,\"available_bikes\":10,\"status\":\"OPEN\",\"last_update\":1618514676000},{\"number\":95,\"contract_name\":\"dublin\",\"name\":\"ROYAL HOSPITAL\",\"address\":\"Royal Hospital\",\"position\":{\"lat\":53.343897,\"lng\":-6.29706},\"banking\":false,\"bonus\":false,\"bike_stands\":40,\"available_bike_stands\":29,\"available_bikes\":11,\"status\":\"OPEN\",\"last_update\":1618514787000},{\"number\":94,\"contract_name\":\"dublin\",\"name\":\"HEUSTON STATION (CAR PARK)\",\"address\":\"Heuston Station (Car Park)\",\"position\":{\"lat\":53.346985,\"lng\":-6.297804},\"banking\":false,\"bonus\":false,\"bike_stands\":40,\"available_bike_stands\":32,\"available_bikes\":8,\"status\":\"OPEN\",\"last_update\":1618514488000},{\"number\":105,\"contract_name\":\"dublin\",\"name\":\"GRANGEGORMAN LOWER (NORTH)\",\"address\":\"Grangegorman Lower (North)\",\"position\":{\"lat\":53.355954,\"lng\":-6.278378},\"banking\":false,\"bonus\":false,\"bike_stands\":36,\"available_bike_stands\":25,\"available_bikes\":11,\"status\":\"OPEN\",\"last_update\":1618514516000},{\"number\":36,\"contract_name\":\"dublin\",\"name\":\"ST. STEPHEN'S GREEN EAST\",\"address\":\"St. Stephen's Green East\",\"position\":{\"lat\":53.337824,\"lng\":-6.256035},\"banking\":false,\"bonus\":false,\"bike_stands\":40,\"available_bike_stands\":36,\"available_bikes\":4,\"status\":\"OPEN\",\"last_update\":1618514940000},{\"number\":93,\"contract_name\":\"dublin\",\"name\":\"HEUSTON STATION (CENTRAL)\",\"address\":\"Heuston Station (Central)\",\"position\":{\"lat\":53.346603,\"lng\":-6.296924},\"banking\":false,\"bonus\":false,\"bike_stands\":40,\"available_bike_stands\":32,\"available_bikes\":8,\"status\":\"OPEN\",\"last_update\":1618514472000},{\"number\":22,\"contract_name\":\"dublin\",\"name\":\"TOWNSEND STREET\",\"address\":\"Townsend Street\",\"position\":{\"lat\":53.345922,\"lng\":-6.254614},\"banking\":false,\"bonus\":false,\"bike_stands\":20,\"available_bike_stands\":4,\"available_bikes\":16,\"status\":\"OPEN\",\"last_update\":1618514757000},{\"number\":50,\"contract_name\":\"dublin\",\"name\":\"GEORGES LANE\",\"address\":\"George's Lane\",\"position\":{\"lat\":53.35023,\"lng\":-6.279696},\"banking\":false,\"bonus\":false,\"bike_stands\":40,\"available_bike_stands\":18,\"available_bikes\":22,\"status\":\"OPEN\",\"last_update\":1618515048000},{\"number\":110,\"contract_name\":\"dublin\",\"name\":\"PHIBSBOROUGH ROAD\",\"address\":\"Phibsborough Road\",\"position\":{\"lat\":53.356307,\"lng\":-6.273717},\"banking\":false,\"bonus\":false,\"bike_stands\":40,\"available_bike_stands\":26,\"available_bikes\":14,\"status\":\"OPEN\",\"last_update\":1618514962000},{\"number\":12,\"contract_name\":\"dublin\",\"name\":\"ECCLES STREET\",\"address\":\"Eccles Street\",\"position\":{\"lat\":53.359246,\"lng\":-6.269779},\"banking\":false,\"bonus\":false,\"bike_stands\":20,\"available_bike_stands\":16,\"available_bikes\":4,\"status\":\"OPEN\",\"last_update\":1618514815000},{\"number\":34,\"contract_name\":\"dublin\",\"name\":\"PORTOBELLO HARBOUR\",\"address\":\"Portobello Harbour\",\"position\":{\"lat\":53.330362,\"lng\":-6.265163},\"banking\":false,\"bonus\":false,\"bike_stands\":30,\"available_bike_stands\":17,\"available_bikes\":13,\"status\":\"OPEN\",\"last_update\":1618514629000},{\"number\":78,\"contract_name\":\"dublin\",\"name\":\"MATER HOSPITAL\",\"address\":\"Mater Hospital\",\"position\":{\"lat\":53.359967,\"lng\":-6.264828},\"banking\":false,\"bonus\":false,\"bike_stands\":40,\"available_bike_stands\":33,\"available_bikes\":7,\"status\":\"OPEN\",\"last_update\":1618514536000},{\"number\":2,\"contract_name\":\"dublin\",\"name\":\"BLESSINGTON STREET\",\"address\":\"Blessington Street\",\"position\":{\"lat\":53.356769,\"lng\":-6.26814},\"banking\":false,\"bonus\":false,\"bike_stands\":20,\"available_bike_stands\":14,\"available_bikes\":6,\"status\":\"OPEN\",\"last_update\":1618514845000},{\"number\":75,\"contract_name\":\"dublin\",\"name\":\"JAMES STREET\",\"address\":\"James Street\",\"position\":{\"lat\":53.343456,\"lng\":-6.287409},\"banking\":false,\"bonus\":false,\"bike_stands\":40,\"available_bike_stands\":26,\"available_bikes\":14,\"status\":\"OPEN\",\"last_update\":1618515031000},{\"number\":111,\"contract_name\":\"dublin\",\"name\":\"MOUNTJOY SQUARE EAST\",\"address\":\"Mountjoy Square East\",\"position\":{\"lat\":53.356717,\"lng\":-6.256359},\"banking\":false,\"bonus\":false,\"bike_stands\":40,\"available_bike_stands\":27,\"available_bikes\":13,\"status\":\"OPEN\",\"last_update\":1618514560000},{\"number\":26,\"contract_name\":\"dublin\",\"name\":\"MERRION SQUARE WEST\",\"address\":\"Merrion Square West\",\"position\":{\"lat\":53.339764,\"lng\":-6.251988},\"banking\":false,\"bonus\":false,\"bike_stands\":20,\"available_bike_stands\":11,\"available_bikes\":9,\"status\":\"OPEN\",\"last_update\":1618514781000},{\"number\":65,\"contract_name\":\"dublin\",\"name\":\"CONVENTION CENTRE\",\"address\":\"Convention Centre\",\"position\":{\"lat\":53.34744,\"lng\":-6.238523},\"banking\":false,\"bonus\":false,\"bike_stands\":40,\"available_bike_stands\":30,\"available_bikes\":10,\"status\":\"OPEN\",\"last_update\":1618514786000},{\"number\":15,\"contract_name\":\"dublin\",\"name\":\"HARDWICKE STREET\",\"address\":\"Hardwicke Street\",\"position\":{\"lat\":53.355473,\"lng\":-6.264423},\"banking\":false,\"bonus\":false,\"bike_stands\":16,\"available_bike_stands\":8,\"available_bikes\":8,\"status\":\"OPEN\",\"last_update\":1618514596000},{\"number\":86,\"contract_name\":\"dublin\",\"name\":\"PARKGATE STREET\",\"address\":\"Parkgate Street\",\"position\":{\"lat\":53.347972,\"lng\":-6.291804},\"banking\":false,\"bonus\":false,\"bike_stands\":38,\"available_bike_stands\":35,\"available_bikes\":3,\"status\":\"OPEN\",\"last_update\":1618514965000},{\"number\":10,\"contract_name\":\"dublin\",\"name\":\"DAME STREET\",\"address\":\"Dame Street\",\"position\":{\"lat\":53.344007,\"lng\":-6.266802},\"banking\":false,\"bonus\":false,\"bike_stands\":16,\"available_bike_stands\":6,\"available_bikes\":10,\"status\":\"OPEN\",\"last_update\":1618514785000},{\"number\":100,\"contract_name\":\"dublin\",\"name\":\"HEUSTON BRIDGE (SOUTH)\",\"address\":\"Heuston Bridge (South)\",\"position\":{\"lat\":53.347106,\"lng\":-6.292041},\"banking\":false,\"bonus\":false,\"bike_stands\":25,\"available_bike_stands\":3,\"available_bikes\":22,\"status\":\"OPEN\",\"last_update\":1618514460000},{\"number\":24,\"contract_name\":\"dublin\",\"name\":\"CATHAL BRUGHA STREET\",\"address\":\"Cathal Brugha Street\",\"position\":{\"lat\":53.352149,\"lng\":-6.260533},\"banking\":false,\"bonus\":false,\"bike_stands\":20,\"available_bike_stands\":15,\"available_bikes\":5,\"status\":\"OPEN\",\"last_update\":1618514612000},{\"number\":64,\"contract_name\":\"dublin\",\"name\":\"SANDWITH STREET\",\"address\":\"Sandwith Street\",\"position\":{\"lat\":53.345203,\"lng\":-6.247163},\"banking\":false,\"bonus\":false,\"bike_stands\":40,\"available_bike_stands\":28,\"available_bikes\":12,\"status\":\"OPEN\",\"last_update\":1618514746000},{\"number\":109,\"contract_name\":\"dublin\",\"name\":\"BUCKINGHAM STREET LOWER\",\"address\":\"Buckingham Street Lower\",\"position\":{\"lat\":53.353331,\"lng\":-6.249319},\"banking\":false,\"bonus\":false,\"bike_stands\":29,\"available_bike_stands\":20,\"available_bikes\":9,\"status\":\"OPEN\",\"last_update\":1618514796000},{\"number\":85,\"contract_name\":\"dublin\",\"name\":\"ROTHE ABBEY\",\"address\":\"Rothe Abbey\",\"position\":{\"lat\":53.338776,\"lng\":-6.30395},\"banking\":false,\"bonus\":false,\"bike_stands\":35,\"available_bike_stands\":18,\"available_bikes\":17,\"status\":\"OPEN\",\"last_update\":1618515045000},{\"number\":107,\"contract_name\":\"dublin\",\"name\":\"CHARLEVILLE ROAD\",\"address\":\"Charleville Road\",\"position\":{\"lat\":53.359157,\"lng\":-6.281866},\"banking\":false,\"bonus\":false,\"bike_stands\":40,\"available_bike_stands\":18,\"available_bikes\":22,\"status\":\"OPEN\",\"last_update\":1618514724000},{\"number\":33,\"contract_name\":\"dublin\",\"name\":\"PRINCES STREET / O'CONNELL STREET\",\"address\":\"Princes Street / O'Connell Street\",\"position\":{\"lat\":53.349013,\"lng\":-6.260311},\"banking\":false,\"bonus\":false,\"bike_stands\":23,\"available_bike_stands\":23,\"available_bikes\":0,\"status\":\"OPEN\",\"last_update\":1618514531000},{\"number\":44,\"contract_name\":\"dublin\",\"name\":\"UPPER SHERRARD STREET\",\"address\":\"Upper Sherrard Street\",\"position\":{\"lat\":53.358437,\"lng\":-6.260641},\"banking\":false,\"bonus\":false,\"bike_stands\":30,\"available_bike_stands\":18,\"available_bikes\":12,\"status\":\"OPEN\",\"last_update\":1618514520000},{\"number\":89,\"contract_name\":\"dublin\",\"name\":\"FITZWILLIAM SQUARE EAST\",\"address\":\"Fitzwilliam Square East\",\"position\":{\"lat\":53.335211,\"lng\":-6.2509},\"banking\":false,\"bonus\":false,\"bike_stands\":40,\"available_bike_stands\":40,\"available_bikes\":0,\"status\":\"OPEN\",\"last_update\":1618514660000},{\"number\":57,\"contract_name\":\"dublin\",\"name\":\"GRATTAN STREET\",\"address\":\"Grattan Street\",\"position\":{\"lat\":53.339629,\"lng\":-6.243778},\"banking\":false,\"bonus\":false,\"bike_stands\":23,\"available_bike_stands\":16,\"available_bikes\":7,\"status\":\"OPEN\",\"last_update\":1618514586000},{\"number\":80,\"contract_name\":\"dublin\",\"name\":\"ST JAMES HOSPITAL (LUAS)\",\"address\":\"St James Hospital (Luas)\",\"position\":{\"lat\":53.341359,\"lng\":-6.292951},\"banking\":false,\"bonus\":false,\"bike_stands\":40,\"available_bike_stands\":30,\"available_bikes\":10,\"status\":\"OPEN\",\"last_update\":1618514899000},{\"number\":41,\"contract_name\":\"dublin\",\"name\":\"HARCOURT TERRACE\",\"address\":\"Harcourt Terrace\",\"position\":{\"lat\":53.332763,\"lng\":-6.257942},\"banking\":false,\"bonus\":false,\"bike_stands\":20,\"available_bike_stands\":4,\"available_bikes\":16,\"status\":\"OPEN\",\"last_update\":1618514665000},{\"number\":3,\"contract_name\":\"dublin\",\"name\":\"BOLTON STREET\",\"address\":\"Bolton Street\",\"position\":{\"lat\":53.351182,\"lng\":-6.269859},\"banking\":false,\"bonus\":false,\"bike_stands\":20,\"available_bike_stands\":13,\"available_bikes\":7,\"status\":\"OPEN\",\"last_update\":1618515004000},{\"number\":40,\"contract_name\":\"dublin\",\"name\":\"JERVIS STREET\",\"address\":\"Jervis Street\",\"position\":{\"lat\":53.3483,\"lng\":-6.266651},\"banking\":false,\"bonus\":false,\"bike_stands\":21,\"available_bike_stands\":20,\"available_bikes\":1,\"status\":\"OPEN\",\"last_update\":1618514692000},{\"number\":29,\"contract_name\":\"dublin\",\"name\":\"ORMOND QUAY UPPER\",\"address\":\"Ormond Quay Upper\",\"position\":{\"lat\":53.346057,\"lng\":-6.268001},\"banking\":false,\"bonus\":false,\"bike_stands\":29,\"available_bike_stands\":7,\"available_bikes\":22,\"status\":\"OPEN\",\"last_update\":1618514734000},{\"number\":103,\"contract_name\":\"dublin\",\"name\":\"GRANGEGORMAN LOWER (SOUTH)\",\"address\":\"Grangegorman Lower (South)\",\"position\":{\"lat\":53.354663,\"lng\":-6.278681},\"banking\":false,\"bonus\":false,\"bike_stands\":40,\"available_bike_stands\":35,\"available_bikes\":5,\"status\":\"OPEN\",\"last_update\":1618515045000},{\"number\":28,\"contract_name\":\"dublin\",\"name\":\"MOUNTJOY SQUARE WEST\",\"address\":\"Mountjoy Square West\",\"position\":{\"lat\":53.356299,\"lng\":-6.258586},\"banking\":false,\"bonus\":false,\"bike_stands\":30,\"available_bike_stands\":11,\"available_bikes\":19,\"status\":\"OPEN\",\"last_update\":1618514918000},{\"number\":39,\"contract_name\":\"dublin\",\"name\":\"WILTON TERRACE\",\"address\":\"Wilton Terrace\",\"position\":{\"lat\":53.332383,\"lng\":-6.252717},\"banking\":false,\"bonus\":false,\"bike_stands\":20,\"available_bike_stands\":7,\"available_bikes\":13,\"status\":\"OPEN\",\"last_update\":1618514840000},{\"number\":83,\"contract_name\":\"dublin\",\"name\":\"EMMET ROAD\",\"address\":\"Emmet Road\",\"position\":{\"lat\":53.340714,\"lng\":-6.308191},\"banking\":false,\"bonus\":false,\"bike_stands\":40,\"available_bike_stands\":21,\"available_bikes\":19,\"status\":\"OPEN\",\"last_update\":1618514647000},{\"number\":92,\"contract_name\":\"dublin\",\"name\":\"HEUSTON BRIDGE (NORTH)\",\"address\":\"Heuston Bridge (North)\",\"position\":{\"lat\":53.347802,\"lng\":-6.292432},\"banking\":false,\"bonus\":false,\"bike_stands\":40,\"available_bike_stands\":40,\"available_bikes\":0,\"status\":\"OPEN\",\"last_update\":1618515040000},{\"number\":21,\"contract_name\":\"dublin\",\"name\":\"LEINSTER STREET SOUTH\",\"address\":\"Leinster Street South\",\"position\":{\"lat\":53.34218,\"lng\":-6.254485},\"banking\":false,\"bonus\":false,\"bike_stands\":30,\"available_bike_stands\":19,\"available_bikes\":11,\"status\":\"OPEN\",\"last_update\":1618514757000},{\"number\":88,\"contract_name\":\"dublin\",\"name\":\"BLACKHALL PLACE\",\"address\":\"Blackhall Place\",\"position\":{\"lat\":53.3488,\"lng\":-6.281637},\"banking\":false,\"bonus\":false,\"bike_stands\":30,\"available_bike_stands\":16,\"available_bikes\":14,\"status\":\"OPEN\",\"last_update\":1618514973000}]"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)


        Log.d("ttaagg", "onCreate: "+ parseJson(jsonStr)?.get(0))
    }

    public data class Pin(
        val lat: Double,
        val long: Double,

    )

    // parse json data
    fun parseJson(data: String): List<Pin>? {
        val list = mutableListOf<Pin>()

        try {
            val array = JSONArray(data);

            for (i in 0 until array.length()) {
                val obj = JSONObject(array[i].toString())


                val obj2= obj.getJSONObject("position")



                val lat = obj2.getDouble("lat")
                val lng = obj2.getDouble("lng")

                Log.i("ttaagg", "parseJson: "+lat)
                list.add(Pin(lat, lng))
            }
        } catch (e: JSONException) {
            Log.d("Exception", e.toString())
        }

        return list
    }
}
