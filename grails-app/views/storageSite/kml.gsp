<%@ page contentType="application/vnd.google-earth.kml+xml;charset=UTF-8" %><?xml version="1.0" encoding="UTF-8"?>
<kml xmlns="http://www.opengis.net/kml/2.2">
  <Style id="normalPlacemark">
    <IconStyle>
      <Icon>
        <href>http://www.storitz.com/images/icn_map_grn.png</href>
      </Icon>
    </IconStyle>
  </Style>
  <StyleMap id="storitzStyleMap">
    <Pair>
      <key>normal</key>
      <styleUrl>#normalPlacemark</styleUrl>
    </Pair>
  </StyleMap>
  <Placemark>
    <name>${site.title.encodeAsXML()}</name>
    <styleUrl>#exampleStyleMap</styleUrl>
    <Point>
      <coordinates>${site.lat},${site.lng},0</coordinates>
    </Point>
    <description>
            <![CDATA[
            <H1>Storitz storage site ${site.title}</H1>
            ${site.description}
            ]]>
    </description>
  </Placemark>
</kml>