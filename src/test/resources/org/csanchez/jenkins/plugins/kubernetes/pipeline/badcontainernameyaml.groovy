podTemplate(label: 'badcontainernameyaml', yaml: """
apiVersion: v1
kind: Pod
metadata:
  labels:
    some-label: some-label-value
spec:
  containers:
  - name: badcontainername_!
    image: busybox
    command:
    - cat
    tty: true
  - name: badcontainername2_!
    image: busybox
    command:
    - cat
    tty: true
"""
) {

    node ('badcontainernameyaml') {
      stage('Run') {
        container('busybox') {
          sh """
            will never run
          """
        }
      }
    }
}