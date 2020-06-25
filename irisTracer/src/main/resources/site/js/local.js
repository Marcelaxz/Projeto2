var margin = {top: 10, right: 30, bottom: 30, left: 60},
    width = 1060 - margin.left - margin.right,
    height = 400 - margin.top - margin.bottom;

var svg = d3.select("#my_dataviz")
  .append("svg")
  .attr("width", width + margin.left + margin.right)
  .attr("height", height + margin.top + margin.bottom)
  .append("g")
  .attr("transform",
     "translate(" + margin.left + "," + margin.top + ")");


d3.json("http://localhost:8080/api/Tracer",

    function(data){

        var parseDate = d3.timeParse("%Y-%m-%d");

        data = data.map(function (d) {
            d.diaCorrido = parseDate(d.diaCorrido);
        let newData = {
            diaCorrido: d.diaCorrido,
            percurso: d.percurso // Mude aqui o campo do json
        }
            return newData;
        });


        data = data.filter(
            function(d) {
                return d.percurso != null;
            }
        );

        var x = d3.scaleTime()
            .domain(d3.extent(data, function(d) { return d.diaCorrido; }))
            .range([ 0, width ]);
        svg.append("g")
            .attr("transform", "translate(0," + height + ")")
            .call(d3.axisBottom(x));


        var y = d3.scaleLinear()
            .domain( d3.extent(data, function(d) { return d.percurso; }))
            .range([ height, 0 ]);
        svg.append("g")
            .call(d3.axisLeft(y));

        svg.append("path")
            .datum(data)
            .attr("fill", "none")
            .attr("stroke", "#0B3D91")
            .attr("stroke-width", 2)
            .attr("d", d3.line()
                .x(function(d) { return x(d.diaCorrido) })
                .y(function(d) { return y(d.percurso) })
            )

        svg
          .append("g")
          .selectAll("dot")
          .data(data)
          .enter()
          .append("circle")
          .attr("cx", function(d) { return x(d.diaCorrido) } )
          .attr("cy", function(d) { return y(d.Percurso) } )
          .attr("r", 2.5)
          .attr("fill", "#FC3D21")
    })
