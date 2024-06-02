// 간트차트
document.getElementById("planBtn").addEventListener("click", function () {
  document.querySelector(".bg02").classList.add("visible");
  document.querySelector(".modal02").classList.add("visible");
});
document.querySelector(".close-modal02").addEventListener("click", function () {
  document.querySelector(".bg02").classList.remove("visible");
  document.querySelector(".modal02").classList.remove("visible");
});
// document.addEventListener("click", function (event) {
//   if (!event.target.closest(".open-modal02, .modal02")) {
//     document.querySelector(".modal02").classList.remove("visible");
//     document.querySelector(".bg02").classList.remove("visible");
//     document.body.classList.remove("modal-open02");
//   }
// });

google.charts.load("current", { packages: ["gantt"] });
google.charts.setOnLoadCallback(drawChart);

var chart;
var data;
var options;

function drawChart() {
  data = new google.visualization.DataTable();
  data.addColumn("string", "Task ID");
  data.addColumn("string", "Task Name");
  data.addColumn("string", "Resource");
  data.addColumn("date", "Start Date");
  data.addColumn("date", "End Date");
  data.addColumn("number", "Duration");
  data.addColumn("number", "Percent Complete");
  data.addColumn("string", "Dependencies");

  // 초기데이터
  data.addRows([[" ", " ", " ", new Date(), new Date(), null, 100, null]]);

  options = {
    height: 400,
    gantt: {
      trackHeight: 30,
    },
    hAxis: {
      format: "d MMM yyyy",
      minValue: new Date(data.getValue(0, 3)),
      maxValue: new Date(data.getValue(0, 4)),
    },
  };

  chart = new google.visualization.Gantt(document.getElementById("chart_div"));
  chart.draw(data, options);
  updateTaskList();
}

function taskValidation(taskName) {
  for (var i = 0; i < data.getNumberOfRows(); i++) {
    if (data.getValue(i, 1) === " ") data.removeRow(i);
    if (data.getValue(i, 1) === taskName) return false;
  }
  return true;
}

function addTask() {
  let taskId = document.getElementById("taskId").value;
  let taskName = document.getElementById("taskName").value;
  if (!taskValidation(taskName)) {
    alert("작업이 중복됩니다!");
    return;
  }
  let resource = document.getElementById("resource").value;
  let startDate = new Date(document.getElementById("startDate").value);
  let endDate = new Date(document.getElementById("endDate").value);
  let dependencies = null;

  if (data.bf.length > 8) {
    options.height = options.height + 100;
  }
  if (confirm("작업을 추가하시겠습니까?") == true) {
    data.addRows([
      [
        taskId,
        taskName,
        resource,
        startDate,
        endDate,
        null,
        null,
        dependencies,
      ],
    ]);
  }

  var minDate = options.hAxis.minValue;
  var maxDate = options.hAxis.maxValue;
  if (startDate < minDate) options.hAxis.minValue = startDate;
  if (endDate > maxDate) options.hAxis.maxValue = endDate;
  chart.draw(data, options);
  updateTaskList();
}

function updateTaskList() {
  let select = document.getElementById("deleteTaskName");
  select.innerHTML = "";
  for (var i = 0; i < data.getNumberOfRows(); i++) {
    let taskName = data.getValue(i, 1);
    if (taskName !== " ") {
      let option = document.createElement("option");
      option.value = taskName;
      option.textContent = taskName;
      select.appendChild(option);
    }
  }
}

function deleteTask() {
  let deleteTaskName = document.getElementById("deleteTaskName").value;
  for (var i = 0; i < data.getNumberOfRows(); i++) {
    if (data.getValue(i, 1) === deleteTaskName) {
      if (confirm(`${data.getValue(i, 1)} 작업을 삭제하시겠습니까?`) == true) {
        data.removeRow(i);
        chart.draw(data, options);
        updateTaskList();
        break;
      }
    }
  }
}
