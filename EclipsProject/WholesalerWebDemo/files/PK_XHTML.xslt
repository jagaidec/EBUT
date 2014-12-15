
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns="http://www.w3.org/1999/xhtml"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
<xsl:output method="xml" indent="yes" 
    doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
    doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"/>
	<!-- allgemeines Template -->
	<xsl:template match="/">
		<html>
				<head>
					<title>Product catalog</title>
					

					<style type="text/css">
					body {
						font-family: Arial, Helvetica;
					}
					</style>
				</head>
				<body>
					<h1 align="center">Product catalog</h1>
					<xsl:apply-templates select="Produktkatalog" />
				</body>
		</html>
	</xsl:template>
	<!-- Produktkatalog -->
	<xsl:template match="Produktkatalog">
		<p align="center">
			Generated:
			<xsl:value-of select="@Generierungsdatum" />
		</p>
		<p align="center">
			Producer:
			<xsl:value-of select="@ErzeugerId" />
		</p>
		<p align="center">
			Name:
			<xsl:value-of select="@Beschreibung" />
		</p>
		<hr />
		<xsl:apply-templates select="Artikel" />
	</xsl:template>
	<!-- Artikel -->
	<xsl:template match="Produktkatalog/Artikel">

		<p>
			<label>
				<b>Article No:</b>
			</label>
			<xsl:value-of select="@Artikelnummer" />
			<br />
			<label>
				<b>Description:</b>
			</label>
			<xsl:value-of select="Kurzbeschreibung" />
			<br />
			<label>
				<b>Long description: </b>
			</label>
			<xsl:apply-templates select="Langbeschreibung" />
			<br />
			<xsl:apply-templates select="Nettopreise | Bruttopreise" />
		</p>
		<hr />

	</xsl:template>
	<!-- Langbeschreibung allgemein -->
	<xsl:template match="Langbeschreibung">
		<xsl:apply-templates />
	</xsl:template>
	<!-- Text Elemente in Langbeschreibung -->
	<xsl:template match="Langbeschreibung/text()">
		<xsl:copy>
			<xsl:copy-of select="." />
			<xsl:apply-templates />
		</xsl:copy>
	</xsl:template>
	<!-- <wichtig> Tags in Langbeschreibung -->
	<xsl:template match="Langbeschreibung//*">
		<em>
			<xsl:value-of select="." />
		</em>
	</xsl:template>
	<xsl:template match="Nettopreise | Bruttopreise">
		<label>
			<b>Country pricing:</b>
		</label>
			<label>
				<xsl:apply-templates select="Preis" />
			</label>

	</xsl:template>
	<!-- Preis -->
	<xsl:template match="Preis">
				<label><xsl:value-of select="Land" />, TAX: <xsl:value-of select="Steuersatz" />%</label> 
				<label>PRICE: <xsl:value-of select="Betrag" /> <xsl:value-of select="@Waehrung" /></label>
	</xsl:template>
	<xsl:template match="sonstArtikelNr">
		<xsl:value-of select="@sonstArtikelnummerTyp" />
		:
		<xsl:value-of select="." />
	</xsl:template>
</xsl:stylesheet>
