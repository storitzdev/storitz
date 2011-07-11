<h4>Office Hours</h4>
<table class="operatingHours">
    <tr>
        <td class="tright" style="width:120px;">
            Mon:
        </td>
        <g:if test="${site.openMonday}">
            <td class="tright">
                <g:formatDate format="h:mma" date="${site.startMonday}"/>
            </td>
            <td>-</td>
            <td class="tright">
                <g:formatDate format="h:mma" date="${site.endMonday}"/>
            </td>
        </g:if>
        <g:else>
            <td colspan="3" style="text-align: center;">Closed</td>
        </g:else>
    </tr>
    <tr>
        <td class="tright" style="width:120px;">
            Tue:
        </td>
        <g:if test="${site.openTuesday}">
            <td class="tright">
                <g:formatDate format="h:mma" date="${site.startTuesday}"/>
            </td>
            <td>-</td>
            <td class="tright">
                <g:formatDate format="h:mma" date="${site.endTuesday}"/>
            </td>
        </g:if>
        <g:else>
            <td colspan="3" style="text-align: center;">Closed</td>
        </g:else>
    </tr>
    <tr>
        <td class="tright" style="width:120px;">
            Wed:
        </td>
        <g:if test="${site.openWednesday}">
            <td class="tright">
                <g:formatDate format="h:mma" date="${site.startWednesday}"/>
            </td>
            <td>-</td>
            <td class="tright">
                <g:formatDate format="h:mma" date="${site.endWednesday}"/>
            </td>
        </g:if>
        <g:else>
            <td colspan="3" style="text-align: center;">Closed</td>
        </g:else>
    </tr>
    <tr>
        <td class="tright" style="width:120px;">
            Thu:
        </td>
        <g:if test="${site.openThursday}">
            <td class="tright">
                <g:formatDate format="h:mma" date="${site.startThursday}"/>
            </td>
            <td>-</td>
            <td class="tright">
                <g:formatDate format="h:mma" date="${site.endThursday}"/>
            </td>
        </g:if>
        <g:else>
            <td colspan="3" style="text-align: center;">Closed</td>
        </g:else>
    </tr>
    <tr>
        <td class="tright" style="width:120px;">
            Fri:
        </td>
        <g:if test="${site.openFriday}">
            <td class="tright">
                <g:formatDate format="h:mma" date="${site.startFriday}"/>
            </td>
            <td>-</td>
            <td class="tright">
                <g:formatDate format="h:mma" date="${site.endFriday}"/>
            </td>
        </g:if>
        <g:else>
            <td colspan="3" style="text-align: center;">Closed</td>
        </g:else>
    </tr>
    <tr>
        <td class="tright" style="width:120px;">
            Sat:
        </td>
        <g:if test="${site.openSaturday}">
            <td class="tright">
                <g:formatDate format="h:mma" date="${site.startSaturday}"/>
            </td>
            <td>-</td>
            <td class="tright">
                <g:formatDate format="h:mma" date="${site.endSaturday}"/>
            </td>
        </g:if>
        <g:else>
            <td colspan="3" style="text-align: center;">Closed</td>
        </g:else>
    </tr>
    <tr>
        <td class="tright" style="width:120px;">
            Sun:
        </td>
        <g:if test="${site.openSunday}">
            <td class="tright">
                <g:formatDate format="h:mma" date="${site.startSunday}"/>
            </td>
            <td>-</td>
            <td class="tright">
                <g:formatDate format="h:mma" date="${site.endSunday}"/>
            </td>
        </g:if>
        <g:else>
            <td colspan="3" style="text-align: center;">Closed</td>
        </g:else>
    </tr>
</table>
<div style="height: 10px;clear:both;width: 210px; border-bottom:1px solid #dfdfdf;margin: 0 0 10px -3px;"></div>
<h4>Gate Hours</h4>
<table class="operatingHours">
    <tr>
        <td class="tright" style="width:120px;">
            Mon:
        </td>
        <td>
            <g:formatDate format="h:mma" date="${site.startMondayGate}"/>
        </td>
        <td>-</td>
        <td class="tright">
            <g:formatDate format="h:mma" date="${site.endMondayGate}"/>
        </td>
    </tr>
    <tr>
        <td class="tright" style="width:120px;">
            Tue:
        </td>
        <td>
            <g:formatDate format="h:mma" date="${site.startTuesdayGate}"/>
        </td>
        <td>-</td>
        <td class="tright">
            <g:formatDate format="h:mma" date="${site.endTuesdayGate}"/>
        </td>
    </tr>
    <tr>
        <td class="tright" style="width:120px;">
            Wed:
        </td>
        <td>
            <g:formatDate format="h:mma" date="${site.startWednesdayGate}"/>
        </td>
        <td>-</td>
        <td class="tright">
            <g:formatDate format="h:mma" date="${site.endWednesdayGate}"/>
        </td>
    </tr>
    <tr>
        <td class="tright" style="width:120px;">
            Thu:
        </td>
        <td>
            <g:formatDate format="h:mma" date="${site.startThursdayGate}"/>
        </td>
        <td>-</td>
        <td class="tright">
            <g:formatDate format="h:mma" date="${site.endThursdayGate}"/>
        </td>
    </tr>
    <tr>
        <td class="tright" style="width:120px;">
            Fri:
        </td>
        <td>
            <g:formatDate format="h:mma" date="${site.startFridayGate}"/>
        </td>
        <td>-</td>
        <td class="tright">
            <g:formatDate format="h:mma" date="${site.endFridayGate}"/>
        </td>
    </tr>
    <tr>
        <td class="tright" style="width:120px;">
            Sat:
        </td>
        <td>
            <g:formatDate format="h:mma" date="${site.startSaturdayGate}"/>
        </td>
        <td>-</td>
        <td class="tright">
            <g:formatDate format="h:mma" date="${site.endSaturdayGate}"/>
        </td>
    </tr>
    <tr>
        <td class="tright" style="width:120px;">
            Sun:
        </td>
        <td>
            <g:formatDate format="h:mma" date="${site.startSundayGate}"/>
        </td>
        <td>-</td>
        <td class="tright">
            <g:formatDate format="h:mma" date="${site.endSundayGate}"/>
        </td>
    </tr>
</table>