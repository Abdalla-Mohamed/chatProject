<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="Session">
        <html>

            <body>


                <xsl:for-each select="msg">

                    <font>

                        <xsl:attribute name="size">
                            <xsl:value-of select="size" />
                        </xsl:attribute>
                        <xsl:attribute name="color">
                            <xsl:value-of
                                select="color" />
                        </xsl:attribute>
                        <!-- <xsl:value-of select="from" />: -->
                        <xsl:attribute name="face">
                            <xsl:value-of select="face" />
                        </xsl:attribute>

                        <xsl:value-of select="body" />
                    </font>



                    <br />

                    <br />
                </xsl:for-each>


            </body>

        </html>

    </xsl:template>
</xsl:stylesheet>