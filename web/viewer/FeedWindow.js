/*

This file is part of Ext JS 4

Copyright (c) 2011 Sencha Inc

Contact:  http://www.sencha.com/contact

GNU General Public License Usage
This file may be used under the terms of the GNU General Public License version 3.0 as published by the Free Software Foundation and appearing in the file LICENSE included in the packaging of this file.  Please review the following information to ensure the GNU General Public License version 3.0 requirements will be met: http://www.gnu.org/copyleft/gpl.html.

If you are unsure which license is appropriate for your use, please contact the sales department at http://www.sencha.com/contact.

*/
/**
 * @class FeedViewer.FeedWindow
 * @extends Ext.window.Window
 *
 * Shows a dialog for creating and validating a new feed.
 * 
 * @constructor
 * Create a new Feed Window
 * @param {Object} config The config object
 */

Ext.define('FeedViewer.FeedWindow', {
    extend: 'Ext.window.Window',
    
    alias: 'widget.feedwindow',

    plain: true,

    defaultFeeds: [
        ['DB2 LUW', 'DB2 LUW'],
        ['DB2 z/OS', 'DB2 z/OS'],
	['MySQL','MySQL'],
        ['Oracle', 'Oracle'],
        ['SQL Server', 'SQL Server']
    ],

    operatingSystems:[
	['Windows Server 2008','Windows 2008'],
	['Windows Server 2003','Windows 2003'],
	['Redhat Enterprise Linux 6.x', 'Redhat Enterprise Linux 6.x'],
	['Redhat Enterprise Linux 5.x', 'Redhat Enterprise Linux 5.x'],
	['SUSE Enterprise Linux 11.x', 'SUSE Enterprise Linux 11.x'],
	['SUSE Enterprise Linux 10.x', 'SUSE Enterprise Linux 10.x'],
	['AIX', 'AIX'],
	['Solaris', 'Solaris'],
	['HP/UX','HP/UX']
      ],

	timeZone: [['-12.0','(GMT -12:00) Eniwetok, Kwajalein'], 
	      ['-11.0','(GMT -11:00) Midway Island, Samoa'], 
	      ['-10.0','(GMT -10:00) Hawaii'], 
	      ['-9.0','(GMT -9:00) Alaska'], 
	      ['-8.0','(GMT -8:00) Pacific Time (US & Canada)'], 
	      ['-7.0','(GMT -7:00) Mountain Time (US & Canada)'], 
	      ['-6.0','(GMT -6:00) Central Time (US & Canada), Mexico City'], 
	      ['-5.0','(GMT -5:00) Eastern Time (US & Canada), Bogota, Lima'], 
	      ['-4.0','(GMT -4:00) Atlantic Time (Canada), Caracas, La Paz'], 
	      ['-3.5','(GMT -3:30) Newfoundland'], 
	      ['-3.0','(GMT -3:00) Brazil, Buenos Aires, Georgetown'], 
	      ['-2.0','(GMT -2:00) Mid-Atlantic'], 
	      ['-1.0','(GMT -1:00 hour) Azores, Cape Verde Islands'], 
	      ['0.0','(GMT) Western Europe Time, London, Lisbon, Casablanca'], 
	      ['1.0','(GMT +1:00) Brussels, Copenhagen, Madrid, Paris'], 
	      ['2.0', '(GMT +2:00)Kaliningrad, South Africa'], 
	      ['3.0','(GMT +3:00) Baghdad, Riyadh, Moscow, St. Petersburg'], 
	      ['3.5','(GMT +3:30) Tehran'], 
	      ['4.0','(GMT +4:00) Abu Dhabi, Muscat, Baku, Tbilisi'], 
	      ['4.5','(GMT +4:30) Kabul'], 
	      ['5.0','(GMT +5:00) Ekaterinburg, Islamabad, Karachi, Tashkent'], 
	      ['5.5','(GMT +5:30) Bombay, Calcutta, Madras, New Delhi'], 
	      ['5.75','(GMT +5:45) Kathmandu'], 
	      ['6.0','(GMT +6:00) Almaty, Dhaka, Colombo'], 
	      ['7.0','(GMT +7:00) Bangkok, Hanoi, Jakarta'], 
	      ['8.0','(GMT +8:00) Beijing, Perth, Singapore, Hong Kong'], 
	      ['9.0','(GMT +9:00) Tokyo, Seoul, Osaka, Sapporo, Yakutsk'], 
	      ['9.5','(GMT +9:30) Adelaide, Darwin'], 
	      ['10.0','(GMT +10:00) Eastern Australia, Guam, Vladivostok'], 
	      ['11.0','(GMT +11:00) Magadan, Solomon Islands, New Caledonia'], 
	      ['12.0','(GMT +12:00) Auckland, Wellington, Fiji, Kamchatka']
	],
    
    initComponent: function(){
        this.addEvents(
            /**
             * @event feedvalid
             * @param {FeedViewer.FeedWindow} this
             * @param {String} title
             * @param {String} url
             * @param {String} description
             */
            'feedvalid'
        );
        
        this.form = Ext.create('Ext.form.Panel', {
        url:'save-form.php',
        frame:true,
        bodyStyle:'padding:5px 5px 0',
        width: 500,
        fieldDefaults: {
            msgTarget: 'side',
            labelWidth: 125 
        },
        defaultType: 'textfield',
        defaults: {
            anchor: '100%'
        },

        items: [{
            fieldLabel: 'Server Name',
            name: 'server_name',
	    id: 'server_name',
            allowBlank:false
        },{
            fieldLabel: 'Server Timezone',
            name: 'server_timezone',
	    id: 'server_timezone',
	    xtype: 'combo',
	    store: this.timeZone
        },{
            fieldLabel: 'Server Software',
            name: 'server_software',
	    id: 'server_software',
	    xtype: 'combo',
	    store: this.defaultFeeds
        },{
            fieldLabel: 'Operating System',
            name: 'server_operating_system',
	    id: 'server_operating_system',
	    xtype: 'combo',
	    store: this.operatingSystems
        }, {
            fieldLabel: 'Server Software Port',
            name: 'server_port',
	    id: 'server_port',
	    allowBlank:false
        }
        ]

    });

        Ext.apply(this, {
            title: 'Add Server',
            iconCls: 'feed',
            layout: 'fit',
            items: this.form,
            buttons: [{
                xtype: 'button',
                text: 'Add Server',
                scope: this,
                handler: this.onAddClick
            }, {
                xtype: 'button',
                text: 'Cancel',
                scope: this,
                handler: this.destroy
            }]
        });

	Ext.getCmp('server_timezone').setValue('-5.0');
        this.callParent(arguments);
    },
    
    /**
     * React to the add button being clicked.
     * @private
     */
    onAddClick: function(){
        var server_name = this.form.getComponent('server_name').getValue();
	var server_software = this.form.getComponent('server_software').getValue();
	var server_timezone = this.form.getComponent('server_timezone').getValue();
	var server_operating_system = this.form.getComponent('server_operating_system').getValue();
	var server_port = this.form.getComponent('server_port').getValue();

        this.form.setLoading({
            msg: 'Validating server...'
        });
        Ext.Ajax.request({
            url: 'tonic/server',
            params: {
                server_name: server_name,
		server_software: server_software,
		server_operating_system: server_operating_system,
		server_timezone: server_timezone,
		server_port: server_port
            },
            success: this.validateFeed,
            failure: this.markInvalid,
            scope: this
        });
    },
    
    /**
     * React to the feed validation passing
     * @private
     * @param {Object} response The response object
     */
    validateFeed: function(response){
        this.form.setLoading(false);
        this.fireEvent('feedvalid', this, 'test2', 'test2');
	this.destroy();
        return;
    },
    
    /**
     * React to the feed validation failing
     * @private
     */
    markInvalid: function(){
        this.form.setLoading(false);
        this.form.getComponent('feed').markInvalid('The URL specified is not a valid RSS2 feed.');
    }
});