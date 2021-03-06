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
Ext.define('CleanData.App', {
	extend: 'Ext.window.Window',

	alias: 'cleandata.window',
	plain: true,

	initComponent: function(){
		
		this.form = Ext.create('Ext.form.Panel', {
			width: 350,
			frame:true,
			items: [{
				    xtype: 'combo',
				    fieldLabel: 'Server',
				    name: 'server',
				    boxLabel: 'Server',
				    height: 100,
				    width: 325,
           			    valueField: 'id',
            			    displayField: 'server_name',
				    id: 'server_name',
				    allowBlank: false,
				    store: Ext.create('Ext.data.Store', {
							model: 'Feed',
							remoteSort: true,
							autoLoad: true,
							autoSync: true,
							proxy: {
							    // load using script tags for cross domain, if the data in on the same domain as
							    // this page, an HttpProxy would be better
							    type: 'rest',
							    url: 'tonic/server',
							    		reader: {
										type: 'json',
										root: 'data'
							    		},
						 		        writer: {
										type: 'json'
									}
							}
				    })

			}]


		});

		Ext.apply(this, {
		    title: 'Clean Server Data',
		    layout: 'fit',
		    items: this.form,
		    buttons: [{
		        xtype: 'button',
		        text: 'Clean Data For Server',
		        scope: this,
		        handler: this.onCleanClick
		    }, {
		        xtype: 'button',
		        text: 'Cancel',
		        scope: this,
		        handler: this.destroy
		    }]
		});
		this.callParent(arguments);
	},

	onCleanClick: function(){
		this.form.setLoading({
		    msg: 'Validating clean data request...'
		});

		var server		= this.form.getComponent('server_name').getValue();

		Ext.Ajax.request({
		    url: 'tonic/jobs',
		    params: {
			server_id:server,
			preprocessor: 'com.dbauditcloud.job.DeleteData'
		    },
		    success: this.validRequest,
		    failure: this.invalidRequest,
		    scope: this
		});
	},

	validRequest: function(){
		this.form.setLoading(false);
		Ext.Msg.alert('Clean Data Request', 'The job submission to remove the data for the server has been submitted sucessfully. The effects will be immediate for all new executions of jobs and alerts.');
		this.destroy();
	},

	invalidRequest: function(){
		this.form.setLoading(false);
		Ext.Msg.alert('Clean Data Request', 'Failed! The job request to remove data was denied. Please try again later');
		this.destroy();
	}
});
