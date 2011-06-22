/** 
 * JDAL Java Script Library
 * 
 * @author Jose Luis Martin
 */

if (typeof JDAL == "undefined" || !JDAL) {
    var JDAL = {};
}

// Build requests strings friendly to JDAL 
JDAL.requestBuilder = function(oState, oSelf) {
    // Get states or use defaults
    oState = oState || { pagination: null, sortedBy: null };
    var sort = (oState.sortedBy) ? oState.sortedBy.key : "id";
    var dir = (oState.sortedBy && oState.sortedBy.dir === YAHOO.widget.DataTable.CLASS_DESC) ? "desc" : "asc";
    var startIndex = (oState.pagination) ? oState.pagination.recordOffset : 0;
    var results = (oState.pagination) ? oState.pagination.rowsPerPage : 100;
 
    // Build custom request
    return  "sort=" + sort +
            "&dir=" + dir +
            "&startIndex=" + startIndex +
            "&pageSize=" + results;
};

//DataTable  default configuration 
JDAL.defaultTableConfig = {
	generateRequest : JDAL.requestBuilder,
	dynamicData : true, // Enables dynamic server-driven data 
	sortedBy : {
		key : "id",
		dir : YAHOO.widget.DataTable.CLASS_ASC
	}, // Sets UI initial sort arrow 
	paginator : new YAHOO.widget.Paginator( {
		rowsPerPage : 25
	}) // Enables pagination  
};
