<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <title>${pressReleaseInstance.title}</title>
</head>
<body class="static">
<div class="right">
  <h1>${pressReleaseInstance.title}</h1>
  <h3>${pressReleaseInstance.releaseDate.format('MM-dd-yyyy')}</h3>
  <div>
    ${pressReleaseInstance.body}
  </div>
  <g:if test="${pressReleaseInstance.pdfLocation!=null}">
      <p>
          <a href="${resource(file: pressReleaseInstance.pdfLocation)}" onclick="window.open(this.href, '_blank');
          return false;"><storitz:image src="icn_pdf.jpg" width="36" height="36" alt="PDF"/></a>
      </p>
  </g:if>
  <p>
    <strong>Tags:</strong> ${pressReleaseInstance.tags}
  </p>
</div>
</body>
</html>