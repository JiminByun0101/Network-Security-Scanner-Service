<template>

    <v-card outlined>
        <v-card-title>
            InitiateScan
        </v-card-title>

        <v-card-text>
            <String label="Hostname" v-model="value.hostname" :editMode="editMode"/>
            <String label="IpAddress" v-model="value.ipAddress" :editMode="editMode"/>
            <String label="ToolName" v-model="value.toolName" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="initiateScan"
            >
                InitiateScan
            </v-btn>
            
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'InitiateScanCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.hostname = '';
            this.value.ipAddress = '';
            this.value.toolName = '';
        },
        watch: {
        },
        methods: {
            initiateScan() {
                this.$emit('initiateScan', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

