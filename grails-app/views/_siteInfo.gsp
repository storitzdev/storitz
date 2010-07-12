<div class="left" style="margin-bottom: 10px;">
  <div id="site_logo">
    <g:if test="${site?.logo}">
      <img src="${resource(file:site.logo.src())}" alt="${site.title} Logo"/>
    </g:if>
  </div>
  <div id="site_address">
    <div class="title">
      ${site.title}
    </div>
    <div>
      ${site.address}
    </div>
    <div>
      ${site.address2}
    </div>
    <div>
      ${site.city}, ${site.state} ${site.zipcode}
    </div>
  </div>
</div>
<div style="clear:both;"></div>
<div class="siteInfoText">
  Weekdays:
  <g:if test="${site.openWeekday}">
    <g:formatDate format="h:mma" date="${site.startWeekday}"/> - <g:formatDate format="h:mma" date="${site.endWeekday}"/>
  </g:if>
  <g:else>Closed</g:else>
</div>
<div class="siteInfoText">
  Saturday:
  <g:if test="${site.openSaturday}">
    <g:formatDate format="h:mma" date="${site.startSaturday}"/> - <g:formatDate format="h:mma" date="${site.endSaturday}"/>
  </g:if>
  <g:else>Closed</g:else>
</div>
<div class="siteInfoText">
  Sunday:
  <g:if test="${site.openSunday}">
    <g:formatDate format="h:mma" date="${site.startSunday}"/> - <g:formatDate format="h:mma" date="${site.endSunday}"/>
  </g:if>
  <g:else>Closed</g:else>
</div>
<div style="height: 10px;"></div>
<div style="width: 280px;" class="siteInfoText">
  <g:if test="${site.description && site.description.size() > 90}">
    <div id="partialDescription" class="left">
      ${site.description.decodeHTML().substring(0, site.description.decodeHTML().lastIndexOf(' ', 90))}
    </div>
    <div id="hiddenDescription" style="display: none;">
      ${site.description.decodeHTML()}
    </div>
    <div style="clear: both;"></div>
    <div id="moreDescription" class="expanding">
      <div class="right">
        <a href="#" style="text-decoration: none;" onclick="Effect.toggle('partialDescription', 'appear', {queue: 'end', duration: 0.1}); Effect.toggle('moreDescription', 'appear', {queue: 'end', duration: 0.1}); Effect.BlindDown('hiddenDescription', {queue: 'end'});Effect.toggle('lessDescription', 'appear', {queue: 'end', duration: 0.1});return false;"><img src="${resource(dir:'images', file:'icon-plus.png')}" style="border: none;" alt="plus icon"/> More</a>
      </div>
    </div>
    <div id="lessDescription" style="display: none;" class="expanding">
      <div class="right">
        <a href="#" style="text-decoration: none;" onclick="Effect.toggle('partialDescription', 'appear', {queue: 'end', duration: 0.1}); Effect.toggle('lessDescription', 'appear', {queue: 'end', duration: 0.1}); Effect.BlindUp('hiddenDescription'); Effect.toggle('moreDescription', 'appear', {queue: 'end', duration: 0.1});return false;"><img src="${resource(dir:'images', file:'icon-minus.png')}" style="border: none;" alt="minus icon"/> Less</a>
      </div>
    </div>
  </g:if>
  <g:else>
  ${site.description?.decodeHTML()}
  </g:else>
</div>
<div style="height: 18px;"></div>
