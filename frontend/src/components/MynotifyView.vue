<template>

    <v-data-table
        :headers="headers"
        :items="mynotify"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'MynotifyView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "orderid", value: "orderid" },
                { text: "foodid", value: "foodid" },
                { text: "deliveryid", value: "deliveryid" },
                { text: "deliverystatus", value: "deliverystatus" },
                { text: "orderstatus", value: "orderstatus" },
            ],
            mynotify : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/mynotifies'))

            temp.data._embedded.mynotifies.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.mynotify = temp.data._embedded.mynotifies;
        },
        methods: {
        }
    }
</script>

