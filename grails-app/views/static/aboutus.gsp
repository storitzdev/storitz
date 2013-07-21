<html>
<head>
  <title>About Storitz.com</title>
  <meta name="DESCRIPTION" content="Find out more about Storitz the company on our about us page."/>
</head>

<body class="static">
<div class="right">

  <div class="toc">
    <a href="#contact">Contact Us</a>
    <a href="#press">Press Room</a>
    <a href="#jobs">Careers</a>
  </div>

  <h2><a name="contact">Contact Us</a></h2>

  <p>Questions?  Concerns?  Comments?  Love Letters?</p>

  <p>Call Us: (877) 456-2929
  <br />Email Us: info @ storitz.com
  <br />Tweet Us: @storitzdotcom</p>

  <h2><a name="press">Press Room</a></h2>

  <p>We love attention!  Check out these mentions of our company:</p>

  <ul>
    <g:each in="${pressReleases}" var="release">
      <li><g:link mapping="release" params="[title:release.title, date:release.releaseDate.format('MM-dd-yyyy'), id:release.id]" id="${release.id}">${release.title}</g:link></li>
    </g:each>
  </ul>

  <h2><a name="jobs">Careers</a></h2>

  <p>Want to be a part of the Storitz team?  Our office is high energy and hard working and we're always looking for talent.  Send your resum&eacute; to jobs@storitz.com </p>


</div>
</body>
</html>