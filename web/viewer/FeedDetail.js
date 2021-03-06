/* 
 *   This file is part of the Open Database Audit Project (ODAP).
 *
 *   ODAP is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   Foobar is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
 *
 *   The code was developed by Rob Williams
 */


Ext.define('FeedViewer.FeedDetail', {

    extend: 'Ext.panel.Panel',
    alias: 'widget.feeddetail',
    border: false,
    initComponent: function(){
        this.display = Ext.create('widget.feedpost', {});
        Ext.apply(this, {
            layout: 'border',
            items: [this.createGrid(), this.createSouth(), this.createEast()],
            listeners: {
		beforeClose: this.beforeClose
            }
        });
        this.relayEvents(this.display, ['opentab']);
        this.relayEvents(this.grid, ['rowdblclick']);
        this.callParent(arguments);
    },

    /**
     * Loads a feed.
     * @param {String} url
     */
    loadFeed: function(url){
        this.grid.loadFeed(url);
    },

    /**
     * Creates the feed grid
     * @private
     * @return {FeedViewer.FeedGrid} feedGrid
     */
    createGrid: function(){
        this.grid = Ext.create('widget.feedgrid', {
            region: 'center',
            dockedItems: [this.createTopToolbar()],
            flex: 2,
            minHeight: 200,
	    server_id: this.server_id,
            minWidth: 150,
            listeners: {
                scope: this,
                select: this.onSelect
		
            }
        });
        this.loadFeed(this.url);
        return this.grid;
    },
	beforeClose: function(var1,var2){
		this.grid.runner.stopAll();
	},
    /**
     * Fires when a grid row is selected
     * @private
     * @param {FeedViewer.FeedGrid} grid
     * @param {Ext.data.Model} rec
     */
    onSelect: function(grid, rec) {
        this.display.setActive(rec);
    },

    /**
     * Creates top controller toolbar.
     * @private
     * @return {Ext.toolbar.Toolbar} toolbar
     */
    createTopToolbar: function(){
        this.toolbar = Ext.create('widget.toolbar', {
            cls: 'x-docked-noborder-top',
            items: [{
                iconCls: 'open-all',
                text: 'Streaming View',
                enableToggle: true,
                pressed: true,
                scope: this,
                toggleHandler: this.onStreamingView
            },{
		iconCls: 'open-all',
		handler: this.refreshView,
		text: 'Refresh',
		scope: this
	    }]
        });
        return this.toolbar;
    },

    /**
     * Reacts to the open all being clicked
     * @private
     */
    onOpenAllClick: function(){
        this.fireEvent('openall', this);
    },

    /**
     * Gets a list of titles/urls for each feed.
     * @return {Array} The feed details
     */
    getFeedData: function(){
        return this.grid.store.getRange();
    },

    /**
     * Create the south region container
     * @private
     * @return {Ext.panel.Panel} south
     */
    createSouth: function(){
        this.south =  Ext.create('Ext.container.Container', {
            layout: 'fit',
            region: 'south',
            split: true,
            flex: 2,
            minHeight: 150,
            items: this.display
        });
        return this.south;
    },

    /**
     * Create the east region container
     * @private
     * @return {Ext.panel.Panel} east
     */
    createEast: function(){
        this.east =  Ext.create('Ext.panel.Panel', {
            layout: 'fit',
            region: 'east',
            flex: 1,
            split: true,
            hidden: true,
            minWidth: 150,
            border: false
        });
        return this.east;
    },

    onStreamingView: function(button, state){
	if(state == false){
		this.grid.runner.stopAll();
	}else{
		this.grid.createRefreshTask();
	}
    },

    refreshView: function(){
	this.grid.store.load();
    }
});
